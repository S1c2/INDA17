public class PrimeChecker
{
	    public boolean isPrime(int n)
    {
        int x = 2;
        while (x<=(n-1))
        {
            if(n%x == 0)
            {
                return false;
            }
            
            x++;
            
        }
        
        return true;
    }

    public static void main(String [ ] args)
    {
    	PrimeChecker pC = new PrimeChecker();

    	for(int i = 1; i<26;i++)
    	{

    		boolean test = pC.isPrime(i);

    		if (test == true)
    		{
    			System.out.println(i + "is a Prime!");
    		}
    		else
    		{
    			System.out.println(i + "is not a Prime");
    		}

    	}

    }

}