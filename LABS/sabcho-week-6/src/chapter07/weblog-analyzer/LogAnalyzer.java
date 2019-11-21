/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    /**
 * Return the number of accesses recorded in the log
 * file.
 */

//Answer to exercise 4.73 oh 4.74
    public int numberOfAccesses()
    {
        int total = 0;
        // Add the value in each element of hourCounts // to total.
        
        for(int hour = 0; hour < hourCounts.length; hour++) {

            total = total + hourCounts[hour];
            
        }
        
        return total;
    }
    
    //Answer to exercise 7.75
    //Answer to 7.77
    /**
     * the second of the two will be returned if two hours are the most busy
     * and they have the same value
     */
    public int busiestHour()
    {
        int busiestHour= 0;
        int hour = 0;
        int i = 0;


        for(hour = 0; hour < hourCounts.length; hour++)
        {
            if (busiestHour <= hourCounts[hour])
            {
                
                busiestHour = hourCounts[hour];
                i = hour;
                
            }

        }
        
        return i;
        
    }
    
    //  Answer to exercise 4.76
    
        public int quitetestHour()
    {
        int busiestHour= hourCounts[0];
        int hour = 0;
        int i = 0;


        for(hour = 0; hour < hourCounts.length; hour++)
        {
            if (busiestHour >= hourCounts[hour])
            {
                
                busiestHour = hourCounts[hour];
                i = hour;
                
                System.out.println(i);
                
            }

        }
        
        return i;
        
    }
    
    //Answer to 4.78
    public int busiestTwo()
    {
        int busiestHour= hourCounts[0] + hourCounts[1];
        int hour = 0;
        int i = 0;
        int firstHour = 0;


        for(hour = 0; hour < (hourCounts.length)-1; hour++)
        {
            if (busiestHour <= (hourCounts[hour] + hourCounts[hour+1]))
            {
                
                busiestHour = hourCounts[hour] + hourCounts[hour+1];
                i = hour;
                
            }

        }
        
        return i;
     
        
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) 
        {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) 
        {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
