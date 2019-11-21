/**
 *
 * This class uses both Arrays and ArrayLists to:
 *  1. Return a collection of numbers from a specified integer to another specified integer
 *  2. Shuffle a specified collection of integers and return the shuffled collection
 *  3. Sum the integers in a collection iteratively and return the collection
 *  4. Sum the integers in a collection recursively and return the collection
 *
 *  @version 2017-11-23
 *  @author Sabrina Chowdhury
 */

import java.util.*;
import java.lang.*;

public class ListProcessor {

    public static void main(String [] args)
    {
        ListProcessor ListP = new ListProcessor();

        System.out.println(Arrays.toString(ListP.filledArray(0,5)));
        System.out.println(ListP.filledList(0,5));


        //Test for when to=from, should return empty collection

        //System.out.println(ListP.filledList(5,5));
        //System.out.println(Arrays.toString(ListP.filledArray(5,5)));

        //Test for when to>from, should return IllegalArgumentException

        //System.out.println(ListP.filledArray(7,5));
        //System.out.println(ListP.filledList(7,5));

        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(8);
        numberList.add(9);
        numberList.add(10);

        System.out.println(Arrays.toString(ListP.shuffled(numbers)));
        System.out.println(ListP.shuffled(numberList));
        System.out.println(ListP.sumIterative(numbers));
        System.out.println(ListP.sumIterative(numberList));

        System.out.println(ListP.sumRecursive(numbers));
        System.out.println(ListP.sumRecursive(numberList));



    }

    /******************************************************* ANSWER TO EXERCISE 1 *******************************************/

    /**
     *
     * @param from the first element in the array
     * @param to   the last element in the array
     * @return     an array with integers in the range specified by the parameters
     * @throws IllegalArgumentException when to < from
     */

    public int[] filledArray(int from, int to) throws IllegalArgumentException
    {
        int[] anArray;

        if (to<from)
        {
            throw new IllegalArgumentException("The first value in the list must be smaller than the last value");
        }
        else
        {
            anArray = new int[to - from];
        }


        if (from == to)
        {
            return anArray;
        }

        for(int i = from ; i<to ; i++)
        {
            anArray[i-from] = i;



        }

        return anArray;

    }

    /**
     *
     * @param from the first element in the ArrayList
     * @param to   the last element in the ArrayList
     * @return     an ArrayList with integers in the range specified by the parameters
     * @throws IllegalArgumentException when to<from
     */

    public List<Integer> filledList(int from, int to) throws IllegalArgumentException
    {
        ArrayList<Integer> anArrayList = new ArrayList<Integer>();

        if (from == to)
        {
            return anArrayList;
        }

        if (to<from)
        {
            throw new IllegalArgumentException("The first value in the list must be smaller than the last value");
        }


        for (int i = from; i < to; i++)
        {
            anArrayList.add(i-from, i);

        }


        return anArrayList;
    }

    /******************************************************* ANSWER TO EXERCISE 2 *******************************************/

    /**
     * @param numbers an array filled with given numbers
     * @return        a new array containing the same numbers as the array numbers, only shuffled
     */

    public int[] shuffled(int[] numbers)
    {

        //First we want to create an new array called newArray of the same size and numbers
        //for each element in numbers we add it to a random place in newArray
        //at the end of the method, we return newArray


        int[] newArray = new int[numbers.length];
        ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
        Random random = new Random();


        for(int element:numbers)
        {
            int randomPlace;

            //generate a new random number each time you see that it has already been occupied
            do
            {
                randomPlace = random.nextInt(numbers.length);
            } while(usedNumbers.contains(randomPlace));

            newArray[randomPlace] = element;
            usedNumbers.add(randomPlace);

        }

        return newArray;

    }

    /**
     * @param numberList an ArrayList filled with given numbers
     * @return           a new ArrayList containing the same numbers as the ArrayList numbers, only shuffled
     */

    public List<Integer> shuffled(List<Integer> numberList)
    {
        //I will initiate the arraylist to be the size of numberList

        //I will take a random index in numberList
        //I will have to check if I have already taken that index in numberList
        // then take the element in that spot
        // and then add it to the first place in newArrayList


        ArrayList<Integer> newArrayList = new ArrayList<Integer>(numberList.size());
        ArrayList<Integer> usedNumbers = new ArrayList<Integer>(numberList.size());
        Random random = new Random();

        int randomNumber;
        int numberToAdd;
        int getNumber;

        for(int i = 0; i<numberList.size(); i++)
        {

            //generate a new random number each time you see that it has already been occupied
            do
            {
                randomNumber = random.nextInt(numberList.size());

            } while(usedNumbers.contains(randomNumber));

            getNumber = numberList.get(randomNumber);

            newArrayList.add(i, getNumber);
            usedNumbers.add(randomNumber);

        }

        return newArrayList;

    }

    /******************************************************* ANSWER TO EXERCISE 3 *******************************************/

    /**
     * @param numbers an Array filled with given numbers
     * @return        a sum of all the integers in the array
     */

    public int sumIterative(int[] numbers)
    {
        int sum = 0;

        for(int i = 0; i<numbers.length; i++)
        {


            sum = sum + numbers[i];

        }

        return sum;


    }

    /**
     * @param numberList an ArrayList filled with given numbers
     * @return           a sum of all the integers in the ArrayList
     */

    public int sumIterative(List<Integer> numberList)
    {

        int sum = 0;

        for(int i = 0; i<numberList.size(); i++)
        {


            sum = sum + numberList.get(i);

        }

        return sum;

    }

    /******************************************************* ANSWER TO EXERCISE 4 *******************************************/

    /**
     *
     * @param numbers an Array filled with given numbers
     * @return
     */

    public int sumRecursive(int[] numbers)
    {
        if(numbers.length == 0)
        {
            return 0;
        }

        //when there is only one element left, we start counting backwards
        if(numbers.length == 1)
        {

            return numbers[0];
        }

        return numbers[0] + sumRecursive(Arrays.copyOfRange(numbers,1,numbers.length));
        //copyOfRange(the array that is to be copied, he initial index of the range to be copied, the final index of the range to be copied(exclusive))
    }

    /**
     *
     * @param numbers an ArrayList filled with given numbers
     * @return
     */

    public int sumRecursive(List<Integer> numbers)
    {
        if(numbers.size() == 0)
        {
            return 0;
        }

        //when there is only one element left, we start counting backwards
        if(numbers.size() == 1)
        {

            return numbers.get(0);
        }

        return numbers.get(0) + sumRecursive(numbers.subList(1,numbers.size()));

        //return sumRecursive(numbers.subList(1,numbers.size()));
        //gives back the number of elements there are in the list

        //basically for each recursion, we get back a sublist that removes the first element in in the list
        //this sublist becomes the new list and we take the first value of that list, then we make it into a sublist again
        //by removing the first element
        //the recursion starts to actually count (backwards) when we are left with a sublist of only 1 element, we get the
        //item at that index position and then start counting backwards


    }



}