package at.tugraz.sa.controller;

/**
 * Created by paul on 02.12.16.
 */
public class Route {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;

    public Route(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
