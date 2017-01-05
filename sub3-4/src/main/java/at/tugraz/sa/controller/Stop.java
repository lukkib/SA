package at.tugraz.sa.controller;

public class Stop
{
    private String routeId;
    private String stopId;

    public String getRouteId()
    {
        return routeId;
    }

    public String getStopId()
    {
        return stopId;
    }

    public Stop(String routeId, String stopId)
    {
        this.routeId = routeId;
        this.stopId = stopId;
    }
}
