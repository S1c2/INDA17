import java.util.Arrays;
/**
 * Implementation of the Sieve of Eratosthenes algorithm for checking if a
 * number is prime or not. The implementation is lacking in error-checking
 * and optimization, and needs some patching up!
 *
 * @author Sabrina Chowdhury
 * @version 2017-11-16
 */
public class Sieve {
    
    private static final int maxNumber = 67108864;
    //Answer to S.5
    boolean[] primeCache = new boolean[0];
    

    /**
     * Check if user has put in a number below 2 (as it cannot be a prime)
     * or if the number is too big. Throws an IllegalArgumentException if any
     * of these two things happen.
     *
     * @param   number  An integer value to be checked 
     */
    //Answer to S.4
    private void exceptionIfIllegalArg(int number)
    {
        //Answer to S.2 - the if-statement
        if(number<2)
        {
            System.out.println("There are no primes lower than 2");
            throw new IllegalArgumentException();
            
        }
        //Answer to S.3
        if(number > 67108864)
        {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * Return a list of boolean values, e.g in place 5 there should
     * be a true because 5 is a prime number
     *
     * @param   number  An integer value to be checked for primality.
     * @return  an array of size number which holds information on where
     *          the values smaller than or equal to number is a prime or not.
     */
    //Answer to S.4
    private boolean[] sieve(int number)
    {
        boolean[] prime = new boolean[number + 1]; // + 1 because of 0-indexing
        Arrays.fill(prime, true); // assume all numbers are prime
        int sqrt = (int) Math.floor(Math.sqrt(number));
        for (int i = 2; i <= sqrt; i++) 
        {
            if (prime[i]) 
            {
                for (int j = i*2; j < prime.length; j+=i) 
                {
                    prime[j] = false; // mark multiples of i as not prime
                }
            }
        }
        return prime;
    }
    
    /**
     * Returns true if number put in by the user is a prime, and false
     * if the number is not a prime.
     * 
     * The method first calls the exceptionIfIllegalArg(number) method
     * to check if the number is below zero or too big (preferred size is
     * set by the one that writes the program)
     * 
     * Then an if statement to test if the number put in has already been tested
     * The primeCache array saves an already updated list of the primes 
     * If the number is bigger than any previous value tested, a new array
     * is created to include information on the primes that need to be tested
     *
     * @param   number  An integer value to be checked for primality.
     * @return  true if number is a prime and false if number is not a prime
     */
    //Answer to S.4
    public boolean isPrime(int number) throws IllegalArgumentException
    {
        exceptionIfIllegalArg(number);
        //Answer to S.5
        if(primeCache.length <= number)
        {
            //we create a new array that has number + 1 places (but we only pass number to it, because it fixes the +1 part for us
            primeCache = sieve(number);
        }
        else if(primeCache.length > number)
        {
            return primeCache[number];
        }
        //boolean[] prime = sieve(number);
        return primeCache[number];
        //was return prime[number]; before we changed it
    }
    
    /**Answer to S.6
     * One possible implementation could be that instead of having to count from 0 to the number put in by the user every time 
     * primeCache does not contain the required information, we could update it with the numbers from the previous maximum
     * to the current maximum (which is the number put in by the user). We could change the array to an arrayList so that we could
     * reuse the same collection and then just update it every time. E.g. let´s say we have already tested all values up until 10. 
     * The next time, the user asks whether 15 is a prime or not. Instead of testing all values again up until 15, we could just 
     * test all values from 11 to 15 (number - primeCache.length (primeCache.size() in this case because we make it into an 
     * arrayList))
     */

}
