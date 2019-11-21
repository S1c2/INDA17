import java.util.Set;
import java.util.HashMap;
import java.util.*;
import java.lang.*;


/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Sabrina Chowdhury, Michael Kölling and David J. Barnes
 * @version 2017.11.09
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Character> characters = new ArrayList<Character>();


    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();


    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {

        return "You are " + description + ".\n" + getExitString() + ".\n"  +  "A character will ask you a question." + "\n" + 
        "Answer it correctly and you will get a key to unlock any door in this room."+  getCharacters();
    }

    private String getItems()
    {
        String fullString = "";
        

        for(Item item : items)
        {

            fullString = fullString + "\n" + "Item : " + item.getNameOfItem() + "\n" + "Weight : " + item.getWeightOfItem();

        }
        

        return fullString;
    }

    /*
    * Return a string containing all characters
    * @return The name of the character and its question
    */
    private String getCharacters()
    {
        String fullString = "";

        for(Character character : characters)
        {

            fullString = fullString + "\n" + "Character : " + character.getNameOfCharacter() + "\n" + "Question : " + character.getQuestionFromCharacter();

        }
        

        return fullString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }


    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /*
    * create an item that belongs to this room (initially)
    * @param item The item in this room.
    */
    public void createItem(Item item)
    {
        items.add(item);

    }

    /*
    * create a new character for this room
    * @param character The character in this room
    */
    public void createCharacter(Character character)
    {
        characters.add(character);

    }

    
    /*
    * return the character that belongs to this room
    * @return One of (the first in the arraylist) the characters in this room.
    */
    public Character getCharacter()
    {
    
        return characters.get(0);
    }


}

