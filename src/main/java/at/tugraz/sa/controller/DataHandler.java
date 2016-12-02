package at.tugraz.sa.controller;

import at.tugraz.sa.io.CsvReader;
import at.tugraz.sa.io.CsvWriter;

import java.util.ArrayList;
import java.util.List;

public class DataHandler
{
    private List<Stop> stops;
    private List<Route> routes;
    private String path;
    private String routePath;

    public DataHandler()
    {
        this.path = System.getProperty("user.dir").concat("/mapping.csv");
        this.routePath = System.getProperty("user.dir").concat("/routes.csv");
        stops = new ArrayList<Stop>();
        routes = new ArrayList<Route>();
        CsvReader in = new CsvReader(path, routePath,"|");
        stops = in.readCsv();
        routes = in.readRoutes();
    }

    // Return List of all stops within a route
    public List<String> getRoutesofStop(String stopId)
    {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < stops.size(); i++)
        {
            if(compare(stopId, stops.get(i).getStopId()))
            {
                res.add(stops.get(i).getRouteId());
            }
        }
        standardise();
        return res;
    }

    //return Name of Route
    public String getRoutebyID(String id)
    {
        for(int i = 0; i < stops.size(); i++)
        {
            if(routes.get(i).getId().equals(id))
            {
                return routes.get(i).getName();
            }
        }
        return null;
    }


    public void standardise()
    {
        int len;
        for(int i = 0; i < stops.size(); i++)
        {
            stops.get(i).getRouteId().replace("\n", "");
        }

    }

    //TODO: find a better solution for comparing Strings --- .equals() doesn't work properly
    public boolean compare(String str1, String str2)
    {
        for(int i = 0; i < str1.length() && i < str2.length(); i++)
        {
            if(str1.charAt(i) != str2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    public void addStopToLine(String line, String stop)
    {
        String row = line.concat("|").concat(stop).concat("\n");
        CsvWriter writer = new CsvWriter(System.getProperty("user.dir").concat("/mapping.csv"));
        writer.writeLine(row);
    }

    public boolean routeIdAvailable(String routeId)
    {
        for(int i = 0; i < stops.size(); i++)
        {
            if(stops.get(i).getRouteId().equals(routeId))
            {
                return false;
            }
        }
        return true;
    }

    public void addLine(String id, String name)
    {
        String row = id.concat("|").concat(name).concat("n");
        CsvWriter writer = new CsvWriter(System.getProperty("user.dir").concat("/routes.csv"));
        writer.writeLine(row);
    }
}
