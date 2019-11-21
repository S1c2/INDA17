
```

public class TicketMachine
{

    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    //basically how much money I have in my bank account
    private int balance;
    // The total amount of money collected by this machine.
    //Thus when I buy a ticket - my balance should be -money and the
    //total should be +money
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    
    
    /**
     * Version 1 of constructor
     */ 
        public TicketMachine(int cost)
    {
        price = cost;
        balance = 0;
        total = 0;
    }
    
    /**
     * Version 2 of constructor
     * 
       public void Ticketmachine(int specifyPrice)
    {
        price = specifyPrice;
        balance = 0;
        total = 0;
   
    }
     */
    
    /**
    * Version 3 of constructor
    * 
      public void TicketMachine()
    {
        price = 100;
        balance = 0;
        total = 0;
    }
    */
       
    /**
     * Simulates the effect of removing all money from the machine
     * This is a mutator as it changes things
     * 
     * total was added to be zero as it would otherwise show the balance before
     * the machine was emptied
     */
    public void empty()
    {
       total = 0;
    }
    
    public int emptyMachine()
    
    {
        
        int beforeReset = total;
        System.out.println("Total before emptying machine: " + beforeReset);
        total = 0;
        System.out.println("Total now: " + total);
        return beforeReset;
        
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    
     /**
      * VERSION 2 of getBalance
     * will always put balance = 0
     * 
      public int refundBalance()
    {
        balance = 0;
        return balance;
    }
     */
    
     /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * Receive an amount of money from a customer.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // total increases by the price of one ticket 
        //for each sale
        total = total + price;
        // balance is reduced by the price of on ticket
        //for each sale
        balance = balance - price;
    }
}
```
