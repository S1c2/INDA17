
import java.util.*;

/**
 * The BoxProcessor class has methods that can search through and array/list
 * to find a specific Box item (binary and sequential) and can sort an array/list
 *
 * @author Sabrina Chowdhury
 * @version 2017-12-15
 */

public class BoxProcessor {

    /**
     * The main method creates a new array of type Box and adds 10
     * new boxes with different dimensions
     *
     * @param args
     */
    public static void main(String [] args)
    {
        BoxProcessor boxPro = new BoxProcessor();

        Box[] boxArray = new Box[10];
        for(int i = 0; i < boxArray.length; i++)
        {

            Box newBox = new Box(i, i, i);
            boxArray[i] = newBox;
        }

        System.out.println(Arrays.toString(boxArray));
        boxPro.sort(boxArray);
        int seqSearch = boxPro.sequentialSearch(boxArray, boxArray[0]);
        System.out.println(seqSearch);

    }

    /**
     * The sort method sorts an array passed to the method
     * The compareTo method in the Box class is used to make
     * the comparisons
     * @param array an array to be sorted
     */
    public void sort(Box[] array)
    {
        //first test : check that the array has more than one element
        if (array.length > 1)
        {
            int j;
            //create a placeholder of type Box called temp
            Box temp;
            //for loop : will go from second element to last element
            for (int i = 1; i <= array.length - 1; i++)
            {
                j = i;
                //while : element place is not negative (would not make sense)
                //and the element we´re looking at right now is smaller than the element before
                while (j > 0 && (array[j - 1].compareTo(array[j])) > 0)
                {
                    //our placeholder is now our element at position j
                    temp = array[j];
                    //we switch our element at position j with the element before because it was bigger
                    array[j] = array[j - 1];
                    //we assign this element at the position before to be our placeholder
                    array[j - 1] = temp;
                    j--;
                }
            }
        }


    }


    /**
     * A list is passed to the sort method to be sorted
     * @param list a list to be sorted
     */

    public void sort(List<Box> list)
    {
        //check : list has more than one element
        if(list.size()>1)
        {
            int j;
            //placeholder temp
            Box temp;
            //start in second position of list
            for (int i = 1; i <= list.size() - 1; i++)
            {
                j = i;
                //while not at a negative position and element at position j is smaller than element at positon j-1
                while ((j > 0) && ((list.get(j - 1).compareTo(list.get(j))) > 0))
                {
                    temp = list.get(j);
                    //switch the elements as they are in the wrong order
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                    j--;
                }
            }
        }

    }


    /**
     * The sequentialSearch method is passed an array and the name of a box
     * The method searches through the array(starting with the first element)
     * and returns the box if found, if the
     * box is not in the array, however, -1 is returned
     *
     * @param array an array to be searched for a specific box
     * @param box the box that is searched for
     * @return box that is searched for, otherwise -1 if the box cannot be found
     */
    public int sequentialSearch(Box[] array, Box box)
    {
        //for : each element in the array
        for(int i = 0; i<=array.length-1;i++)
        {
            //if the element at index i is the searched for box
            if(array[i].compareTo(box)==0)
            {
                //return the index
                return i;
            }
        }
        //return -1 if the box cannot be found in the array
        return -1;

    }


    /**
     * The sequentialSearch method is passed a list and the name of a box
     * The method searches through the list(starting with the first element)
     * and returns the box if found, if the
     * box is not in the list, however, -1 is returned
     *
     * @param list a list to be searched for a specific box
     * @param box the box that is searched for
     * @return box that is searched for, otherwise -1 if the box cannot be found
     */
    public int sequentialSearch(List<Box> list, Box box)
    {

        //for each element in the list
        for(int i = 0;i<=list.size()-1;i++)
        {
            //if the element is equal to the box searched for
            if(list.get(i).compareTo(box)==0)
            {
                //return the index of the element
                return i;
            }
        }
        //return -1 if the box cannot be found
        //i.e. no element is equal to the box
        return -1;

    }

    /**
     * The binarySearch method is passed an array and box
     * The method searches through the array for the box
     * but starts in the middle. If the box is e.g in the lower
     * half it makes a new middle position in the middle of the
     * lower half and asks on which side the box is in, and so on.
     * -1 is returned if the box cannot be found.
     *
     * @param array an array to be searched
     * @param box a box that is searched for
     * @return the box that is searched for, otherwise -1 if it cannot be found
     */
    public int binarySearch(Box[] array, Box box)
    {

        /*
        if (array.length == 0) {
            return false;
        }
        */
        //AKA the lower end of the array, first index position

        int low = 0;
        //AKA the higher end of the array, last index position
        int high = array.length-1;

        //while the first element is smaller than last element
        while(low <= high) {
            //assign the middle variable to be the index position in the middle of the array
            int middle = (low+high) /2;
            //if the element in the middle position is smaller than the box
            if (box.compareTo(array[middle]) >0 ){
                //the new low is now the first index in the upper half of the "new" array
                low = middle +1;
            } else if (box.compareTo(array[middle])<0){
                //else we go below the middle and create a new high
                high = middle -1;
            } else { // The element has been found
                return middle;
            }
        }
        //return -1 if the element was not found
        return -1;
    }


    /**
     * The binarySearch method is passed a list and box
     * The method searches through the list for the box
     * but always starts in the middle. If the box is e.g in the lower
     * half it makes a new middle position in the middle of the
     * lower half and asks on which side the box is in, and so on.
     * -1 is returned if the box cannot be found.
     *
     * @param list a list to be searched
     * @param box a box that is searched for
     * @return the box that is searched for, otherwise -1 if it cannot be found
     */
    public int binarySearch(List<Box> list, Box box)
    {
        //first pos
        int low = 0;
        //last pos

        //initialize first index of list

        int high = list.size()-1;

        //while first pos <= last pos
        while(low <= high )
        {
            //create a variable for middle pos
            int middle = (low+high) /2;
            //if element at middle pos is smaller than box
            if (box.compareTo(list.get(middle)) >0 )
            //if key is larger than the current middle
            {
                //create a new low above the previous middle
                //make the new low start at the upper half of the list

                low = middle +1;
            }
            else if (box.compareTo(list.get(middle))<0)
            //if key is smaller than the current middle
            {

                //else create a new high below the previous middle
                //make the new high end at the lower half of the list

                high = middle -1;
            }
            else
            { // The element has been found, return it
                return middle;
            }
        }
        //return -1 if the element was not found
        return -1;

    }

}