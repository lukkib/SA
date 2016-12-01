package Controller;

import io.CsvReader;
import io.CsvWriter;

import java.util.*;

/**
 * Created by paul on 30.11.16.
 */
public class DataHandler
{

    private List<Stop> stops;
    private String path;

    public DataHandler() {
        this.path = System.getProperty("user.dir").concat("/mapping.csv");
        stops = new ArrayList<Stop>();
    }

    // Return List of all stops within a route
    public List<String> getRoutesofStop(String stopId)
    {
        CsvReader in = new CsvReader(path, "|");
        stops = in.readCsv();
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
}
