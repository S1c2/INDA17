/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Sabrina Chowdhury, Michael Kölling and David J. Barnes
 * @version 2017.11.09
 */

import java.util.*;

public class CommandWords
{

    /**
     * a constant array that holds all valid command words
     */
    private static final String[] validCommands = {
        "go", "quit", "help", "nothing", "short", "silence", "y", "mount everest"
    };

    
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
       

    }

    /**
     * Check whether a given String is a valid command word. 
     * @param aString The String in the command to be processed.
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out.
     * @return commandList A list of valid commands
     */
    //Answer to 6.18
    public String getCommandList() 
    {
        String commandList = "";
        for(String command: validCommands) {

            commandList = commandList + command + "\n";

        }
        return commandList;

    }



}







