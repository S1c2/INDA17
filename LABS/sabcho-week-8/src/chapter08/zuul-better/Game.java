
/**
*This is the main class of the "World of Zuul" game. It is a very simple,
*text based adventure game. The user can walk from room to room and will meet
*one character in each room.
*
*This main creates and initialises all the others : it creates
*all rooms, characters, items - creates the parser and starts the game.
*It also evaluates and executes the commands that the parser returns. 
*
*
*@author Michael Kölling, David J. Barnes and Sabrina Chowdhury
*@version 2017.11.09
*/

import java.util.HashMap;
import java.util.*;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private CommandWords commands;
    private Character currentCharacter;
    private String currentAnswer;
    private boolean doorLocked = true;
    private int questionsAnsweredRight = 0;




        
    /**
     * Create the game and initialise its internal map, containing all rooms and their characters
     */
    public Game() 
    {
        //at runtime, run this method to create all rooms, characters and items
        createRoomsAndItemsAndCharacters();
        //create an instance of the Parser class
        parser = new Parser();

    }

    /**
     * Run the Game method
     */
    public static void main(String [ ] args)
    {

      Game game = new Game();
      //call play method first
      game.play();
    }


    /**
     * Create all the rooms and link their exits together.
     * Create all the characters and all the items
     */
    private void createRoomsAndItemsAndCharacters()
    {
        //create variables of type Room to store the rooms
        Room outside, theater, pub, lab, office;

        /*

        //create variables of type Item to store the items
        Item car, stage, bar, chemicals, desk,truck;

        */

    


        //create variables of type Character to store the characters
        Character wizzard, teacher, musician, comedian, unicorn;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);


        /*

        //create the items, assign a name, a description and a weight
        car = new Item("car","A blue car is parked on the driveway",1000 );
        truck = new Item("truck","A blue car is parked on the driveway",30000 );
        stage = new Item("stage", "There is a large red stage in the back of the room", 2000000 );
        bar = new Item("bar","In the middle of the room is a bar with two bartenders working",3000);
        chemicals = new Item("chemicals", "There are some dangerous chemicals in here",200);
        desk = new Item("desk","A brown desk stands in the middle of the room",500);

        */

        /*

     
        //set locations for the items
        outside.createItem(car);
        outside.createItem(truck);
        theater.createItem(stage);
        pub.createItem(bar);
        lab.createItem(chemicals);
        office.createItem(desk);

        */

        //create the characters, assign a name, a question for them to ask the user and an answer to the question
        wizzard = new Character("wizzard", "Poor people have it. Rich people need it. If you eat it you die. What is it?", "nothing");
        teacher = new Character("teacher", "What word becomes shorter when you add two letters to it?", "short");
        musician = new Character("musician", "What is so delicate that saying its name breaks it?", "silence");
        comedian = new Character("comedian", "Which is the most curious letter?", "y");
        unicorn = new Character("unicorn", "Before Mount Everest was discovered, what was the highest mountain in the world?", "mount everest");

        //The questions have to also be set in the CommandWords class


        //set locations for the characters
        outside.createCharacter(wizzard);
        theater.createCharacter(teacher);
        pub.createCharacter(musician);
        lab.createCharacter(comedian);
        office.createCharacter(unicorn);

        
        currentRoom = outside;  // start game outside

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Riddles!");
        System.out.println("World of Riddles is a new, incredibly boring adventure game.");
        System.out.println("Here you will meet characters that will ask you questions.");
        System.out.println("If you answer the questions right, you get a key and are able to unlock any door in the room you are in.");
        System.out.println("Each door is locked immediately after you enter it, so you always have to answer a question right before unlocking a door.");
        System.out.println("If you answer three questions(does not have to be different questions) right, you win!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());

    }

    /**
     * Increment questionsAnsweredRight by one each time the player answers a question right, 
     * by calling this method each time that happens
     */
    private void anotherQuestionAnsweredRight()
    {
        questionsAnsweredRight++;
    }



    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        String commandWord = command.getCommandWord();

        currentCharacter = currentRoom.getCharacter();
        

        if(command.isUnknown()) {

            System.out.println("Wrong answer, try again!" + "\n" + "Tip : If you want to go somewhere you have to type go ...");
            return false;
            
        }

        if(commandWord.equals(currentCharacter.getAnswerFromCharacter()))
        {
            System.out.println("Good job!Here is a key - where do you want to go?");
            doorLocked = false;
            anotherQuestionAnsweredRight();

        }

        if(questionsAnsweredRight == 3)
        {
            System.out.println("Congratulations! You won the game!");
            return true;

        }


        if (commandWord.equals("help")) {
            printHelp();
        }

        
        if (commandWord.equals("go") && doorLocked == false) {
           
        
            goRoom(command);
        }

        if(commandWord.equals("go") && doorLocked == true)
        {
            System.out.println("You must say the right answer to get a key!");
        }

        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are: go, quit and help");
        //Answer to 6.18
        /*
        CommandWords commands = new CommandWords();
        System.out.println(commands.getCommandList());
        */

    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param command The command to be processed.
     */
    private void goRoom(Command command) 
    {
        doorLocked = false;
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();


        Room nextRoom = currentRoom.getExit(direction);


        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            //doorLocked = true;



        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command The command to be processed.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
