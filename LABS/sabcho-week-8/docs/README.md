# Game Documentation

### Theme
In this world you are to explore some rooms. However, because the doors are locked, you have to get a key to open the doors that lead to other rooms. In each room, you will meet a character whom will ask you a question - if you answer it right, you get a key and you will then be able to open one of the doors. The doors will lock automatically after you have opened it and entered into another room (outside included)

### How to win/lose
You win when you have successfully answered three questions right. These do not have to be three different questions, so try to find your way back to a room where you know the question asked is simpler if you feel yourself being stuck. 

### Extensions

Exercise 6.44 (8.44)

Add locked doors to your game. The player needs to find (or otherwise obtain) a key to open a door.

Solution : I implemented this using a boolean variable called doorLocked. Each time a user entered the right answer, it was set to false and the user could enter through another door. When the user entered this next room, the doorLocked variable was set to true again. This change was implementer in the Game class, in methods processCommand() and goRoom()

Exercise 6.47 (8.47)

Add characters to the game. Characters are similar to items, but they can talk. They speak some text when you first meet them, and they may give you some help if you give them the right item.

Solution : I implemented this by creating a new class called Character. The characters were created much like the items. The Character class stores information on name, question and answer as the characters ask questions to the user. All characters were stored in an ArrayList in class room so that they could be associated with a specific room. These changes were implemented in the class Character, in the class Room (methods getCharacters(), createCharacter(), getCharacter()) and the class Game (methods createRoomsAndItemsAndCharacters() and processCommand();




