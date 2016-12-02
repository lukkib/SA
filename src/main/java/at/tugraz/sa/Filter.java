package at.tugraz.sa;

import at.tugraz.sa.controller.StopController;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Filter
{
  private String name;
  private String lon;
  private String lat;
  private String lonMode;
  private String latMode;

  public Filter(String name, String lon, String lat, String lonMode, String
    latMode)
  {
    this.name = name;
    this.lon = lon;
    this.lat = lat;
    if (!lon.isEmpty() && (lonMode.equals("<") || lonMode.equals(">")))
    {
      this.lonMode = lonMode;
    }
    else if (!lon.isEmpty())
    {
      // TODO Throw exception
      // String for mode of invalid format
    }
    if (!lat.isEmpty() && (latMode.equals("<") || latMode.equals(">")))
    {
      this.latMode = latMode;
    }
    else if (!lat.isEmpty())
    {
      // TODO Throw exception
      // String for mode of invalid format
    }
  }

  public List<StopsRecord> start() throws SQLException
  {
    StopController sc = new StopController();
    List<StopsRecord> results = new ArrayList<>();

    List<StopsRecord> nameFiltered = new ArrayList<>();
    if (!name.isEmpty())
    {
      nameFiltered = sc.findStops(name);
      if (nameFiltered.isEmpty())
      {
        return nameFiltered;
      }

      if (results.isEmpty())
      {
        results = nameFiltered;
      }
      else
      {
        results.retainAll(nameFiltered);
      }
    }

    List<StopsRecord> lonFiltered = new ArrayList<>();
    if (!lon.isEmpty())
    {
      if (lonMode.equals("<"))
      {
        lonFiltered = sc.filterLessThanLon(lon);
      }
      else if (lonMode.equals(">"))
      {
        lonFiltered = sc.filterGreaterThanLon(lon);
      }
      if (results.isEmpty())
      {
        results = lonFiltered;
      }
      else
      {
        results.retainAll(lonFiltered);
      }
    }

    List<StopsRecord> latFiltered = new ArrayList<>();
    if (!lat.isEmpty())
    {
      if (latMode.equals("<"))
      {
        latFiltered = sc.filterLessThanLat(lat);
      }
      else if (latMode.equals(">"))
      {
        latFiltered = sc.filterGreaterThanLat(lat);
      }
      if (results.isEmpty())
      {
        results = latFiltered;
      }
      else
      {
        results.retainAll(latFiltered);
      }
    }

    return results;
  }
}
