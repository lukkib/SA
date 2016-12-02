import Controller.Planer;
import Controller.DataHandler;
import at.tugraz.sa.controller.StopController;
import io.CsvWriter;
import javafx.application.Application;

import java.util.List;

public class Main extends Application{

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
      try{
        sc.findStop("Don Bosco Bahnhof");
      }
      catch (Exception e)
      {

      }


    }
}