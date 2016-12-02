package at.tugraz.sa.io;

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
public class CsvReader {
    private String path;
    private String separator;
    private List<Stop> stops;

    public CsvReader(String path, String separator) {

        this.path = path;
        this.separator = separator;
    }

    public List<Stop> readCsv()
    {
        List<Stop> stops = new ArrayList<Stop>();
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
}
