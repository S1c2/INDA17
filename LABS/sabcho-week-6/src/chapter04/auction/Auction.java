import java.util.ArrayList;
import java.util.*;

/**
 * A simple model of an auction.
 * The auction maintains a list of lots of arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class Auction
{
    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;
    
    
    

    /**
     * Create a new auction.
     */
    public Auction()
    {
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }
    
    //Answer to exercise 4.48
    
    public void close()
    { 
        for(Lot lot : lots)
        //private ArrayList<Lot> lots;
        //this means that Lot is the element type
        {
            if (lot.getHighestBid()!=null)
            //this means that there has been at least one bid
            //getHighestBid is a method in the Lot class
            //it returns highestBid
            
            {
                
                long winningBid = lot.getHighestBid().getValue();
                //long is another type of field
                //This class is connected to the Lot class through lot 
                //and in Lot we look at the getHighestBid() method to 
                //get the highest bid, however we have to look at what
                //getHighestBid() returns (it is Bid - which is an instance
                //of the class Bid, and then in Bid we reach getValue() which
                //returns a value of type long. 
                //long is an integer with larger capacity than int
                //there winningBid must be of type long and not type it
                
                String highestBidder = lot.getHighestBid().getBidder().getName();
                
                System.out.println("The winning bid : " + winningBid);
                System.out.println("The successful bidder : " + highestBidder);
                
                
                
            }
            else
            {
                System.out.println("No bidder on this item");
                //print out message saying no bidder
            }
            
        }
    }
    
    //Answer to exercise 4.49
    public ArrayList<Lot> getUnsold()
    {
        ArrayList<Lot> unsoldLots = new ArrayList<Lot>();
        for(Lot lot : lots)
        {
            if (lot.getHighestBid()==null)
            {
                //saves all unsold lots in an arraylist
                
                
                unsoldLots.add(lot);
                
            }
            
        }
        
        return (unsoldLots);
    }
    
    /**
     * Answer to exercise 4.50
     * If there was a method to remove a lot without updating the lotNumber
     * fields of each lot there we would get the wrong lot when calling the getLot
     * method as it relies on us not to remove any lots. e.g let´s say there is
     * lot 1,2,3,4 - if we remove lot 3, the arrayList will automatically
     * be updated to 1,2,4 and thus if we search for e.g. lot in position 2
     * we would get the wrong lot
     */
    
    //Answer to exercise 4.52
    public Lot removeLot(int lotToRemove)
    {
        
        for(Lot lot : lots) 
        {
            if (lotToRemove > 0)
            {
                lot = getLot(lotToRemove);
            }
            if(lot != null) 
            {
                lots.remove(lot);
            }
            
            return lot;
        }
        
        return null;
     
    }

    /**
     * Enter a new lot into the auction.
     * @param description A description of the lot.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }
    
    /**
     * Make a bid for a lot.
     * A message is printed indicating whether the bid is
     * successful or not.
     * 
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value  The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Report which bid is higher.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null
     * if a lot with this number does not exist.
     * @param lotNumber The number of the lot to return.
     */
//Answer to exercise 4.51
    public Lot getLot(int lotNumber)
        {
            
        for(Lot lot : lots)
        {
            
            if(lot.getNumber()==lotNumber)
            {
                
                return lot;
                
            }

        }
        return null; 
        
}
}
