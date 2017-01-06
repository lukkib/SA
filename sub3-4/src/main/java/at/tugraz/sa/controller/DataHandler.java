package at.tugraz.sa.controller;

import at.tugraz.sa.io.CsvReader;
import at.tugraz.sa.io.CsvWriter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler
{
    private List<Stop> stops;
    private List<Route> routes;
    private List<Restaurant> restaurants;
    private String path;
    private String routePath;
    private String restaurantPath;
    private String newRoute;


    public DataHandler()
    {
        this.path = System.getProperty("user.dir").concat("/mapping.csv");
        this.routePath = System.getProperty("user.dir").concat("/routes.csv");
        stops = new ArrayList<Stop>();
        routes = new ArrayList<Route>();
        CsvReader in = new CsvReader(path, routePath, restaurantPath,"|");
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
        for(int i = 0; i < routes.size(); i++)
        {
            if(routes.get(i).getId().equals(id))
            {
                return routes.get(i).getName();
            }
        }
        return null;
    }

    //return Id of route
    public String getRoutebyName(String name)
    {
        for(int i = 0; i < routes.size(); i++)
        {
            if(compare(name, routes.get(i).getName()))
            {
                System.out.println(routes.get(i).getName());
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
        int j;
        for(int i = 0; i < str1.length() && i < str2.length(); i++)
        {
            j = i + 1;
            if(j == str1.length() && j < str2.length() && '0' <= str2.charAt(j) && str2.charAt(j)  <= '9')
            {
                return false;
            }
            if(j == str2.length() && j < str1.length() && '0' <= str1.charAt(j) && str2.charAt(j)  <= '9')
            {
                return false;
            }
            if(str1.charAt(i) != str2.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    //Adds a stop with a line to the mapping.csv
    public void addStopToLine(String line, String stop)
    {
        String routeId = getRoutebyName(line);
        if(routeId == null)
        {
            routeId = newRoute;
        }
        String row = routeId.concat("|").concat(stop).concat("\n");
        CsvWriter writer = new CsvWriter(System.getProperty("user.dir").concat("/mapping.csv"));
        writer.writeLine(row);
    }

    public boolean routeIdAvailable(String routeId)
    {
        for(int i = 0; i < routes.size(); i++)
        {
            if(routes.get(i).getId().equals(routeId))
            {
                return false;
            }
        }
        return true;
    }
    public boolean routeExists(String name)
    {
        for(int i = 0; i < routes.size(); i++)
        {
            if(compare(name, routes.get(i).getName()))
            {
                return true;
            }
        }
        return false;
    }

    public String generateRouteId()
    {
        int j = 1;
        for(int i = 0; i < routes.size(); i++)
        {
            if(j < Integer.parseInt(routes.get(i).getId()))
            {
                j = Integer.parseInt(routes.get(i).getId());
            }
        }
        j++;
        return Integer.toString(j);
    }

    public void addLine(String name)
    {
        if(!(routeExists(name)))
        {
            String id = generateRouteId();
            newRoute = id;
            String row = id.concat("|").concat(name).concat("\n");
            CsvWriter writer = new CsvWriter(System.getProperty("user.dir").concat("/routes.csv"));
            writer.writeLine(row);
        }
    }

    public ArrayList<Restaurant> findRestaurantsNearStop(String name, String distance)
    {
        ArrayList<Restaurant> res = new ArrayList<>();
        double lat;
        double lon;
        double dist;

        try
        {
            StopController stopController = new StopController();
            lat = Double.parseDouble(stopController.findStopLatByName(name));
            lon = Double.parseDouble(stopController.findStopLonByName(name));
            dist = Double.parseDouble(distance);
            BoundingBox box = new BoundingBox(lon, lat, dist);
            VenuesController venuescontroller = new VenuesController();
            res = venuescontroller.inBox(box.getMinLon(), box.getMaxLon(), box.getMinLat(), box.getMaxLat());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return res;
    }
}
