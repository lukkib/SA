package at.tugraz.sa.io;

import at.tugraz.sa.controller.Restaurant;
import at.tugraz.sa.controller.Route;
import at.tugraz.sa.controller.Stop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 */
public class CsvReader
{
    private String path;
    private String routePath;
    private String restaurantPath;
    private String separator;

    public CsvReader(String path,String routePath, String restaurantPath,String separator)
    {
        this.path = path;
        this.routePath = routePath;
        this.restaurantPath = restaurantPath;
        this.separator = separator;
    }

    public List<Stop> readCsv()
    {
        List<Stop> stops = new ArrayList<>();
        try
        {
            //Initialize Scanner
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter("\n");
            StringTokenizer tok;
            //Skipping first line
            scanner.next();
            //Get new line as long as there are more lines
            while (scanner.hasNext())
            {
                //Splitting line into tokens
                tok = new StringTokenizer(scanner.next(), separator);
                // Creating and adding a stop to the stops list
                Stop stop = new Stop(tok.nextToken(), tok.nextToken());
                stops.add(stop);
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return stops;
    }

    public List<Route> readRoutes()
    {
        List<Route> routes = new ArrayList<>();
        try
        {
            //Initialize Scanner
            Scanner scanner = new Scanner(new File(routePath));
            scanner.useDelimiter("\n");
            StringTokenizer tok;
            //Skipping first line
            scanner.next();
            while(scanner.hasNext())
            {
                //Splitting line into tokens
                tok = new StringTokenizer(scanner.next(), separator);
                // Creating and adding a stop to the stops list
                Route route = new Route(tok.nextToken(), tok.nextToken().replace("\r",""));
                routes.add(route);
            }
            scanner.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return routes;
    }
    /*
    public List<Restaurant> readRestaurants()
    {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(new File(restaurantPath));
            scanner.useDelimiter("\n");
            StringTokenizer tok;
            scanner.next();
            while(scanner.hasNext())
            {
                tok = new StringTokenizer(scanner.next(), "\t");
                Restaurant restaurant = new Restaurant(tok.nextToken(), tok.nextToken(), tok.nextToken(), tok.nextToken());

                if(tok.hasMoreTokens())
                {
                    restaurant.setWebsite(tok.nextToken());
                }

                restaurants.add(restaurant);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return restaurants
    }
    */
}
