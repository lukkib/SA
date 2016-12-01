package Controller;

/**
 * Created by paul on 30.11.16.
 */
public class Stop {
    private String routeId;
    private String stopId;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public Stop(String routeId, String stopId) {

        this.routeId = routeId;
        this.stopId = stopId;
    }
}
