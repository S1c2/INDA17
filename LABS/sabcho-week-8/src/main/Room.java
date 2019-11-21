/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

import java.util.HashMap;
import java.util.Set;

public class Room 
{
    public String description;
    private HashMap<String, Room> exits;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */

    /**
    * Define an exit from this room.
    * @param direction The direction of the exit.
    * @param neighbor The room in the given direction.
    */
    //Answer to 6.8
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }


    //Answer to 6.6
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
    * Return a description of the room’s exits,
    * for example "Exits: north west".
    * @return A description of the available exits.
    */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        return returnString;
    }


    /**
    * Return the description of the room (the one that was
    * defined in the constructor).
    */
    public String getDescription()
    {
        return description;
    }

    /**
    * Return a long description of this room, of the form:
    * You are in the kitchen.
    * Exits: north west
    * @return A description of the room, including exits.
    */

    //Answer to 6.11
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

}
