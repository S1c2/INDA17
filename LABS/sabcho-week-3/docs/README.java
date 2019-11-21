//Code and HW answers week 3 (also for week 2)

/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class BetterTicketMachine
{
    // The price of a ticket from this machine.
    private static int price;
    // The amount of money entered by a customer so far.
    private static int balance;
    // The total amount of money collected by this machine.
    private static int total;
    
    static boolean discount = false;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public BetterTicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
        public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }



public boolean checkDiscount()
{
    discount = true;
    return discount;
}

public void printTicket()
{

int amountLeftToPay = price-balance;
        if(discount ==false && amountLeftToPay<=0) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else if (discount==true && amountLeftToPay<=0)
        {
            int discountValue = 50;
            price = price - discountValue;
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert: " + amountLeftToPay + " cents more into your account");
                    
        }
    }
    

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    
}
/*

Week 3

Answers to book questions:

Homework

Study sections 2.13, 2.14 and 2.19 -- 2.23 of the course textbook (5th or 6th ed).

Please complete exercises 2.52 -- 2.57 and 2.62 -- 2.63 (from last week's reading material) and also 2.64 -- 2.82. 
You do not need to submit this homework, but you must be prepared to discuss it.

2.52

Well each time a ticket is printed there is an if statement that checks if the balance is larger or equal to the price
of the ticket. As the price of the ticket is subtracted from the balance inside the brackets of the if statement it
will never be able to go below 0. In the else statement (i.e. when the balance is lower than the price of a ticket)
we output that we have to put in more money to be able to afford the ticket.

2.53

+ addition
- subtraction
* multiplication
/ division
    5/3 gives 1 , this is because int/int = int
    5.0/3 gives 1.6666666... , this is because float/int = float or float/float = int or int/float = float
% modulus or remainder after division
== equal to
!= not equal to
< less than
> greater than
<= less than or equal to
>= greater than or equal to
&& and
|| or (press alt + 7 on mac)
^ exclusive or
! not

2.54

double saving = price*discount

2.55

double mean = total/count

2.56

if(price>brudget)
{
    System.out.println("Too expensive");
}
else
{
    System.out.println("Just right");
}

2.57

if(price>brudget)
{
    System.out.println("Too expensive, buy something that does not cost more than: " + budget);
}
else
{
    System.out.println("Just right");
}

2.62

public void printTicket()

int amountLeftToPay = price-balance;
    {
        if(amountLeftToPay<=0) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else {
            System.out.println("You must pay: " + amountLeftToPay + " cents more");
                    
        }
    }

2.63

declare at top of class

static boolean discount = false;

and then add the method checkDiscount()

then change printTicket()
to have another conditional statement

public boolean checkDiscount()
{
    discount = true;
    return discount;
}

public void printTicket()
{

int amountLeftToPay = price-balance;
        if(discount ==false && amountLeftToPay<=0) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else if (discount==true && amountLeftToPay<=0)
        {
            int discountValue = 50;
            price = price - discountValue;
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert: " + amountLeftToPay + " cents more into your account");
                    
        }
    }

2.64

return type : String
name : getCode

2.65

name of method : setCredits
name of parameter : creditValue
type of parameter : int

2.66

public void Person()
{
    
}

2.67

String name;
int age;
String code;
int credits;

2.68

public module(String moduleCode)
{
    code = moduleCode;
}

2.69

public Person(String myName, int myAge)
{
    name = myName;
    age = myAge;
}

2.70

public int getAge()
{
    return age;
}

2.71

public String getName()
{
    return name;
}

2.72

public void setAge(int theAge)
{
    age = theAge;
}

2.73

public printDetails()
{
    System.out.println("The name of this person is " + name);
}

2.74

Don´t really understand the question


Name Benjamin Jonson
ID = 738321

2.75

Henry5572

2.76

it will probably get an error as there is an indexplace that the program cannot reach

2.77

if(fullName.length<4 && studentId<3)
{
    System.out.println("error");
}
else
{
    //whatever you wan´t to do
}


2.78

public String getLoginName()
{
    if(fullName.length<4 && studentId<3)
{
    System.out.println("error");
}
else
{
    System.out.println(name + id)
}
}

2.79

102
catfish
cat9
12cat
cat39
f
error

2.80

There wasn´t really a question to answer here, but it worked

2.81

The same thing, because everything that is in t1 becomes t2
Basically t1 in the disguise of t2, as if it only changed its name 

2.82

It returned nothing
It turned out that what we sent to t1 was stored in t2. 
Because t2 is initiated later, it is t2 that is changed
however, t1 does not cease to exist and therefore whatever we 
do to t1 is passed to t2

*/
