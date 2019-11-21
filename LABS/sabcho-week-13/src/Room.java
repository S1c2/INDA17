package src;

/**
 * Created by Sabrina on 1/18/18.
 */
public class Room {
    private String name;
    private String location;

    public Room(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getDetails() {
        return this.name + ", in " + this.location;
    }
}