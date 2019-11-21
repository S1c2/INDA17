import java.util.*;

/**
 * A class for reversing List and array types.
 *
 * @author Sabrina Chowdhury
 * @version 2017-12-07
 */
public class Reverse
{

    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */

    public int[] reversed(int[] array) {
        int[] copyOfArray = Arrays.copyOf(array, array.length);
        for (int left = 0, right = copyOfArray.length - 1; left < right; left++,right--) {
            // swap the values at the left and right indices
            int x = copyOfArray[left];
            copyOfArray[left]  = copyOfArray[right];
            copyOfArray[right] = x;

        }
        return copyOfArray;
    }


    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */

    public List<Integer> reversed(List<Integer> list) {

        List<Integer> copyOfList = new ArrayList<Integer>(list);

        for (int left = 0, right = copyOfList.size() - 1; left < right; left++,right--) {
            // swap the values at the left and right indices
            int x = copyOfList.get(left);
            copyOfList.set(left, copyOfList.get(right));
            copyOfList.set(right,x);

        }
        return copyOfList;
    }


}