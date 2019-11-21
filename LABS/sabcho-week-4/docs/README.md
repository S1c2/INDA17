# Exercise 3.1

## Think again about the lab-classes project that we discussed in Chapter 1 and Chapter 2. Imagine that we create a LabClass object and three Student objects. We then enroll all three students in that lab. Try to draw a class diagram and an object diagram for that situation. Identify and explain the differences between them.


   Class diagram : shows the static view (the state when we have written the program, but before we run it)
   Sorry for the weird format - just imagine LabClass being in a square box.


   *-*-*-*-*-*-*
   *  LabClass *
   *************
         |
         |________________>>> ***********
         		          * Student *
         		          ***********

    Object diagram: shows the dynamic view (at runtime) - because we have programmed it to create 3 student objects when it runs

    ********************                 **********
    *  LabClass        *          _______* Student*
    *  --------        *         |       * Sabrina*	
    *                  *         |	     **********
    *  students[0] ___ *_________|
    *                  *                *********
    *  students[1] ___ *---------|      *Student*
    *                  *         |______*Sabbe  *    
    *  students[2] ___ * ___            *********
    ********************   |         *********
                           |________ *Student*
                                     *Sab    *
           			         *********


# Exercise 3.2

## At what time(s) can a class diagram change? How is it changed?

When something in the class is changed, e.g.:
	- you change the name of a class
	- you remove a class
	- you add a class

# Exercise 3.3

## At what time(s) can an object diagram change? How is it changed?

When either something in the objects or class changes, e.g.:
	- you make any changes similar to the changes above, i.e. you 
	change something in the class
	- you add an object

# Exercise 3.9

## Which of the following expressions return true?

! (4 < 5) FALSE

! false TRUE

(2 > 2) ││ ((4 == 4) && (1 < 0)) FALSE

(2 > 2) ││ (4 == 4) && (1 < 0) FALSE

(34 != 33) && ! false TRUE

After writing your answers on paper, open the Code Pad in BlueJ and try it out. Check your answers. 

## Assistant's note: While you can easily get the correct answers for this exercise by simply using the code pad, trying to work out how each expression is evaluated beforehand is a good mental exercise!

# Exercise 3.10

## Write an expression using boolean variables a and b that evaluates to true when a and b are either both true or both false.

a&&b||!a&&!b

# Exercise 3.11

## Write an expression using boolean variables a and b that evaluates to true when only one of a and b is true, and that is false if a and b are both false or both true. (This is also called an exclusive or.)

a&&!b || a!&&b

## Assistant's requirement: Any sane programmer would use the XOR operator (^) for this, and present the solution a^b. However, this is an exercise in boolean logic using AND, NOT and OR, so you are not allowed to be a sane programmer for this particular exercise!

# Exercise 3.12

## Consider the expression (a && b). Write an equivalent expression (one that evaluates to true at exactly the same values for a and b) without using the && operator.

!(!a || !b)

# Exercise 3.21

## Rewrite the increment method without the modulo operator, using an if statement. Which solution is better?

	value = value + 1;
        if (value == limit) 
        {
            value = value - limit;
        }

# Exercise 3.26

## Write the signature of a constructor that matches the following object creation instruction:

## new Editor("readme.txt", –1)
## Assistant's note: Refresh your knowledge of the method signature by having a look at the assistant's note on exercise 1.33 from week 1!

Editor(String,int)

# Exercise 3.27

## Write Java statements that define a variable named window of type Rectangle, and then create a rectangle object and assign it to that variable. The rectangle constructor has two int parameters.

Rectangle window = new Rectangle(2,3)

# Exercise 3.30

## Given a variable Printer p1; which currently holds a reference to a printer object, and two methods inside the Printer class with the headers

## public void print(String filename, boolean doubleSided)
public int getStatus(int delay)
write two possible calls to each of these methods.

p1.print("Hej", true);
p1.print("Hejdå", false);

p1.getStatus(3);
p1.getStatus(5);

## Assistant's note: That makes four method calls in total!

# Exercise 3.31

## Change the clock from a 24-hour clock to a 12-hour clock. Be careful: This is not as easy as it might at first seem. In a 12-hour clock, the hours after midnight and after noon are not shown as 00:30, but as 12:30. Thus, the minute display shows values from 0 to 59, while the hour display shows values from 1 to 12!

Send 12 to NumberDisplay instead of 24 and modify the setTime method according to the following code (also includes
what to with the minutedisplay):

    public void setTime(int hour, int minute)
    {
        
        if (minute > 59)
        {   
            //minute = 60k + a
            hour = hour + minute/60;
            minute = minute%60;
            
        }
        
        if (hour > 12)
        {
            hour = hour%12;
            if(hour == 0)
            {
                hour = 12;
            }
        }
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }
