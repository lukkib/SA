import Controller.Planer;
import Controller.dataHandler;
import io.CsvWriter;

import java.util.List;

public class Main {

    public static void main(String[] args)
    {

        dataHandler handler = new dataHandler();
        //handler.printStopsOfRoute("23294");
        Planer planer = new Planer("288769777", "288715949");
        List<String> routes = planer.findConnections(handler);
        for(int i = 0; i < routes.size(); i++)
        {
            System.out.println(routes.get(i));
        }
        handler.addStopToLine("lineId","stopId");

    }
}