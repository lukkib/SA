package at.tugraz.sa.controller;

public class BoundingBox {
    private String maxLon;
    private String minLon;
    private String maxLat;
    private String minLat;
    private double standard = 111111;

    public BoundingBox(double lon, double lat, double distance) {
        this.maxLat = String.valueOf(lat + (distance/standard));
        this.minLat = String.valueOf(lat - (distance/standard));
        this.maxLon = String.valueOf(lon + Math.cos(lat) * (distance/standard));
        this.minLon = String.valueOf(lon - Math.cos(lat) * (distance/standard));
    }

    public String getMaxLon() {
        return maxLon;
    }

    public String getMinLon() {
        return minLon;
    }

    public String getMaxLat() {
        return maxLat;
    }

    public String getMinLat() {
        return minLat;
    }
}

