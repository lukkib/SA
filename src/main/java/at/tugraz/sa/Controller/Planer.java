package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 30.11.16.
 */
public class Planer {
    private String start;
    private String end;


    public Planer(String start, String end)
    {
        this.start = start;
        this.end = end;
    }

    public List<String> findConnections(dataHandler handler)
    {
        List<String> res1 = handler.getRoutesofStop(start);
        List<String> res2 = handler.getRoutesofStop(end);
        List<String> routes = new ArrayList<String>();

        for(int i = 0; i < res1.size(); i++)
        {
            for(int j = 0; j < res2.size(); j++)
            {
                if(res1.get(i).equals(res2.get(j)))
                {
                    routes.add(res1.get(i));
                    //TODO: remove before release
                    //System.out.println(res1.get(i) + "  " + res2.get(j) + " = " + res1.get(i).equals(res2.get(j)));
                }
            }
        }
        return routes;
    }


}
