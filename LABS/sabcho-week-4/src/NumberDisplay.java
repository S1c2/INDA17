/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int rollOverLimit)
    {  
            limit = rollOverLimit;
            value = 0;
        
    }

    /**
     * Return the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Return the display value (that is, the current value as a two-digit
     * String. If the value is less than ten, it will be padded with a leading
     * zero).
     */
  
    
    public String getDisplayValue()
    {
        if(value < 10 ){
            //ok so we know that by the time the hour value reaches this point it has become 0 and not 12
            System.out.println("<10:"+ value);
            return "0" + value;
        }
        else {
            
            System.out.println("else:" + value);
            return "" + value;
        }
    }

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue <= limit)) {
            value = replacementValue;
            //ok so we know that the hour does not reach this
            //i.e. the value does not go along with the terms in the if statement
            //because we want the value 12 to pass through and we have set the limit to 12
            //we have to change the if statement so that replacementValue is smaller than OR EQUAL to the limit
            System.out.println("setValue:" + value);
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the
     * limit is reached.
     */
    
    public void incrementMin()
    {
        value = (value + 1) % limit;
    }
    
    public void incrementHour()
    {
        value = (value+1)%limit;
        System.out.println("hourvalue1st" + value);
        if (value == 0)
        {
            value = 12;
            System.out.println("hourinc : " + value);
        }
    }
    
}


