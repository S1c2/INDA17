Exercise 6.1 Open the project zuul-bad. (This project is called “bad” because its implemen-
tation contains some bad design decisions, and we want to leave no doubt that this should not

be used as an example of good programming practice!) Execute and explore the application.
The project comment gives you some information about how to run it.
While exploring the application, answer the following questions:
■ What does this application do?
■ What commands does the game accept?
■ What does each command do?
■ How many rooms are in the scenario?
■ Draw a map of the existing rooms.

Exercise 6.2 After you know what the whole application does, try to find out what each indi-
vidual class does. Write down for each class its purpose. You need to look at the source code

to do this. Note that you might not (and need not) understand all of the source code. Often,
reading through comments and looking at method headers is enough.

Exercise 6.3 Design your own game scenario. Do this away from the computer. Do not

think about implementation, classes, or even programming in general. Just think about invent-
ing an interesting game. This could be done with a group of people.

The game can be anything that has as its base structure a player moving through different
locations. Here are some examples:
■ You are a white blood cell traveling through the body in search of viruses to attack...
■ You are lost in a shopping mall and must find the exit...
■ You are a mole in its burrow and you cannot remember where you stored your food
reserves before winter...
■ You are an adventurer who searches through a dungeon full of monsters and other
characters...
■ You are from the bomb squad and must find and defuse a bomb before it goes off...
Make sure that your game has a goal (so that it has an end and the player can “win”). Try to
think of many things to make the game interesting (trap doors, magic items, characters that
help you only if you feed them, time limits... whatever you like). Let your imagination run wild.
At this stage, do not worry about how to implement these things.

Exercise 6.4 Draw (on paper) a map for the game you invented in Exercise 6.3. Open the
zuul-bad project and save it under a different name (e.g., zuul). This is the project you will use
for making improvements and modifications throughout this chapter. You can leave off the
-bad suffix, because it will (hopefully) soon not be that bad anymore.
As a first step, change the createRooms method in the Game class to create the rooms and
exits you invented for your game. Test!

Exercise 6.4 Draw (on paper) a map for the game you invented in Exercise 6.3. Open the
zuul-bad project and save it under a different name (e.g., zuul). This is the project you will use
for making improvements and modifications throughout this chapter. You can leave off the
-bad suffix, because it will (hopefully) soon not be that bad anymore.
As a first step, change the createRooms method in the Game class to create the rooms and
exits you invented for your game. Test!

Exercise 6.5 Implement and use a separate printLocationInfo method in your
project, as discussed in this section. Test your changes.

Exercise 6.6 Make the changes we have described to the Room and Game classes.

Exercise 6.7 Make a similar change to the printLocationInfo method of Game so that
details of the exits are now prepared by the Room rather than the Game. Define a method in
Room with the following signature:
/**
* Return a description of the room’s exits,
* for example, "Exits: north west".
* @return A description of the available exits.
*/
public String getExitString()

Exercise 6.8 Implement the changes described in this section in your own zuul project.

Exercise 6.9 Look up the keySet method in the documentation of HashMap. What does it do?

Exercise 6.10 Explain, in detail and in writing, how the getExitString method shown in
Code 6.7 works.

Exercise 6.11 Implement the changes described in this section in your own zuul project.

Exercise 6.12 Draw an object diagram with all objects in your game, the way they are just
after starting the game.

Exercise 6.13 How does the object diagram change when you execute a go command?

Exercise 6.14 Add the look command to your version of the zuul game.

Exercise 6.15 Add another command to your game. For a start, you could choose some-
thing simple, such as a command eat that, when executed, just prints out “You have eaten

now and you are not hungry any more.” Later, we can improve this so that you really get hun-
gry over time and you need to find food.

Exercise 6.16 Implement the improved version of printing out the command words, as
described in this section.

Exercise 6.17 If you now add another new command, do you still need to change the Game
class? Why?

Exercise 6.18 Implement the suggested change. Make sure that your program still works
as before.

Exercise 6.19 Find out what the model-view-controller pattern is. You can do a web search
to get information, or you can use any other sources you find. How is it related to the topic
discussed here? What does it suggest? How could it be applied to this project? (Only discuss
its application to this project, as an actual implementation would be an advanced-challenge
exercise.)

Exercise 6.20 Extend either your adventure project or the zuul-better project so that a room
can contain a single item. Items have a description and a weight. When creating rooms and
setting their exits, items for this game should also be created. When a player enters a room,
information about an item present in this room should be displayed.

Exercise 6.21 How should the information be produced about an item present in a room?
Which class should produce the string describing the item? Which class should print it?
Why? Explain in writing. If answering this exercise makes you feel you should change your
implementation, go ahead and make the changes.

Exercise 6.22 Modify the project so that a room can hold any number of items. Use a
collection to do this. Make sure the room has an addItem method that places an item into the
room. Make sure all items get shown when a player enters a room.



Exercise 6.44 (8.44)

Add locked doors to your game. The player needs to find (or otherwise obtain) a key to open a door.

Exercise 6.47 (8.47)

Add characters to the game. Characters are similar to items, but they can talk. They speak some text when you first meet them, and they may give you some help if you give them the right item.


Basically the idea is to have all doors to all exits be locked and to exit through and exit the user must talk to the mystical person 
in the room who will ask them some questions (Will get harder as we get through the game) and if the user manages to answer them right, they get a key which they can use to unlock the door. 

We have to add conditions to the go east, south ... because the doors will be locked, unless the user answers a questions right
so when they type in "go east" - we must say "You have to answer the question right first"

