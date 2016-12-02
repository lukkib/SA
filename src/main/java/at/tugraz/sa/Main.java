package at.tugraz.sa;

import at.tugraz.sa.controller.DataHandler;
import at.tugraz.sa.controller.Planer;
import at.tugraz.sa.controller.StopController;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        DataHandler handler = new DataHandler();
        //handler.printStopsOfRoute("23294");
        Planer planer = new Planer("288769777", "288715949");
        List<String> routes = planer.findConnections(handler);
        for(int i = 0; i < routes.size(); i++)
        {
            System.out.println(routes.get(i));
        }
        handler.addStopToLine("lineId","stopId");

        StopController sc = new StopController();
        try
        {
//          System.out.println(sc.findStop("Don Bosco Bahnhof"));
//          List<StopsRecord> rs = sc.findStops("straße");

          Filter filter = new Filter("straße","15.4326432","47.0521516",
            "<",
            ">");
          List<StopsRecord> rs = filter.start();
          for (StopsRecord stop : rs)
          {
            System.out.println(stop);
          }
          System.out.println("Total stops found: " + rs.size());
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
    }
}