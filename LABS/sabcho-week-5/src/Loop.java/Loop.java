
/**
 * Write a description of class Loop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Loop
{

    //Answer to 4.30
    public void multiplesOfFive()
    { 
        int mod;
        int x = 10;
        while(x<=95)
        {
            mod = x%5;
            if (mod == 0)
            {
                System.out.println(x);
            }
            x++;
        }
    } 
    
    //Answer to 4.31
    public void printSum()
    {
        int x = 1;
        int sum = 0;
        while (x <= 10)
        {
            sum = sum + x;
            
            x++;
        }
        System.out.println(sum);
        
    }
    
    //Answer to 4.32
    public int sum(int a, int b)
    {
      int sum = 0;
      while (a <= b)
      {
          sum = sum + a;
          
          a++;
          
          
      }
      return sum;
    }
    
    //Answer to 4.33
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
}

