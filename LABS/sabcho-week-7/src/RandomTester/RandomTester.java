import java.util.*;

public class RandomTester
{
    //Answer to 5.14
    public void printOneRandom()
    {
        Random randomGenerator = new Random();
        //nextInt generates a random integer 
        int randomInt = randomGenerator.nextInt();
        System.out.println(randomInt);
        
       
    }
    
    //Answer to 5.14
    public void printMultiRandom(int howMany)
    {
        //for loop, loops n = howMany number of times
        for(int nr = 0; nr < howMany; nr++)
        {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt();
            System.out.println(randomInt);
            
        }
    }
    
    //Answer to 5.16
    public int throwDice()
    {
        Random randomGenerator = new Random();
        int diceThrow = randomGenerator.nextInt(6);
        //nextInt(x) returns an integer between 0 and x(without including x), 
        //therefore we have to change x before the output as it could be 0
        return (diceThrow+1);
    }
    
    //Answer to Exercise 5.18
    public String getResponse()
    {
        ArrayList<String> responseList = new ArrayList<>();
        //use .add to add elements to the array list
        responseList.add("Hello, how are you?");
        responseList.add("Sorry, I do not understand");
        responseList.add("Can you be more clear?");
        responseList.add("I am fine thank you");
        responseList.add("That´s funny");
        responseList.add("Goodbye");
        
        Random randomGenerator = new Random();
        //use .size to count the number of elements in the array list
        int sizeOfResponseList = responseList.size();
        //nextInt(x) returns an integer between 0 and x(without including x)
        //which is perfect because we are trying to reach an index between 0 and x-1
        int randomResponseIndex = randomGenerator.nextInt(sizeOfResponseList);
        //use .get to retrieve a random element (in this case a string) from the array list
        String randomChosenResponse = responseList.get(randomResponseIndex);
        return (randomChosenResponse);
       
    }
    
    //Answer to 5.20
    public int randInRangeMinMax(int min, int max)
    {
        Random randomGenerator = new Random();
        //add 1 to max (because it is inclusive) and then subtract with min to get the range
        //add min to the randomly generated number to account for the digits you took away
        int randomInt = randomGenerator.nextInt(max + 1 - min) + min;
        return randomInt;
        
    }
    
    //Answer to 5.20
    public String getResponseUsingMinAndMaxMethod()
    {
        ArrayList<String> responseList = new ArrayList<>();
        //use .add to add elements to the array list
        responseList.add("Hello, how are you?");
        responseList.add("Sorry, I do not understand");
        responseList.add("Can you be more clear?");
        responseList.add("I am fine thank you");
        responseList.add("That´s funny");
        responseList.add("Goodbye");
        
        int sizeOfResponseList = responseList.size();
        // call the previous method to generate a nr so that an element in the index can be chosen
        // do sizeOfResponseList -1 as the index goes from 0 to the size of the list minus 1
        int randomResponseIndex = randInRangeMinMax(0, sizeOfResponseList-1);
        String randomChosenResponse = responseList.get(randomResponseIndex);
        return (randomChosenResponse);
       
    }
    
}
