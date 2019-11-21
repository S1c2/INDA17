import java.util.LinkedList;
import java.util.List;


/**
 * A hash table-based implementation of the Set interface.
 *
 * This is a hashtable where each index in the table contains a linked list - or rather a pointer to the first node in a linked list
 *
 * BIBLE FOR FUTURE HEADACHES WITH HASHTABLES
 *
 * In a hash table the index number is somehow related to the data at that index
 * e.g. we want to populate an array
 * We want to add the name Anna, we will get the ASCII code of all the letters and add them together
 * then we divide this by the number of elements in the array
 * we take the remainder of that calculation, which will become the index for the place where Anna will be
 * Thus the index is decided : index = (sum of ASCII) mod size of array
 * But what if we could put more information at that index
 * e.g. that Anna is 27 years old, that she is a teacher etc.
 *
 * A hashing algorithm is something that translates the information taken from
 * a piece of data that is to be added to a hashset and turns it into an
 * appropriate index number
 * It applies the algorithm to so called keys and tranforms it into an index also called an "adress"
 * For numeric keys we often use the method of taking the key mod size of availabe adresses/index numbers
 * For alphanumeric keys we take the asci code mod size of available adresses
 * However there are many other hash algorithms to choose from some better than others, depending on the nature of your data
 *
 * Collisions happen when we calculate an index for a new piece of data to add, where the index is already occupied
 * For this piece of data we look for the nearest place forward in the array where we can put the piece of data
 * This particular addressing technique is called linear probing, where we find the next available slot if a place is occupied
 * However we will find a problem with looking up data when there has been collisions
 * The more items in a hashtable, the larger the likelihood for collisions
 * One way to deal with this is to create a larger hashtable than needed, that is - more space than the amount of data you have
 * so that e.g. 70% of the hashtable is every occupied, meaning every time you add data, it expands
 * The ratio between the number of occupied index places and the size of the array is called the load factor
 * E.g. if we use an arraylist, which is dynamic, the resizing can happen automatically when the load factor reaches a certain threshold
 *
 * Another way to deal with collisions is known as chaining
 * Instead of placing Anna at index X we put a pointer at index X which points to Anna and this becomes the pointer to the first node in a linked list
 * When e.g. Bill is calculated to be at index X aswell, Bill is just added as another node to the linked list which also contains Anna.
 * Anna is thus pointing to bill
 *
 * @author Sabrina Chowdhury
 * @version 08-02-2018
 */
public class HashSet<T> implements Set<T> {
    private List<T>[] table;
    private int sizeOfSet;
    
    /**
     * Creates a hash table with the given capacity (amount of buckets).
     *
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "capacity must be a positive, non-zero value! Provided: " + capacity);
        }

        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /* 
         * This array will contain only LinkedList<T>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
        @SuppressWarnings("unchecked") // for this declaration only
        List<T>[] t = new LinkedList[capacity];
        
        table = t;
    }

    /**
     * Adds the given element to the set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    public boolean add(T elem) {

        if(elem == null || contains(elem)) {
            //if the element is null or the set already contains the element
            //the hashset does not allow for duplicates
            return false;
        }
        int index = getListIndex(elem);
        List<T> list = table[index];
        //this list is at the position of the element
        //meaning we have expanded it sideways
        if(list == null) {
            //if there isn´t already a linked list created here, we create a pointer here
            //to the first node in a linked list at this index position
            list = table[index] = new LinkedList<T>();
        }
        //adds the element as the first piece of information
        list.add(0,elem);
        //we increment the size
        sizeOfSet++;
        return true;
    }

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    public boolean remove(T elem) {
        if(elem == null || !contains(elem)) {
            //if the element is null or the set does not contain the element
            return false;
        }
        //we assure that we have the correct list
        List<T> list = getList(elem);
        //we cannot retrieve something if there is nothing in the list
        if(list == null) {
            return false;
        }
        //we remove the element from the list
        boolean removed = list.remove(elem);
        //decrement the size of the set
        sizeOfSet--;
        return removed;
    }

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {

        //the element cannot be null
        if(elem == null) {
            return false;
        }

        List<T> list = getList(elem);
        if(list == null) {
            return false;
        }
        boolean contains = list.contains(elem);
        return contains;
    }


    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    public int size() {
        return sizeOfSet;

    }

    /**
     * This method will return the list in which the given element is in
     * @param elem
     * @return
     */
    private List<T> getList(T elem) {
        int index = getListIndex(elem);
        List<T> list = table[index];
        return list;
    }

    /**
     * This method will decide an index for a given data value which is to be put in the hashtable
     * @param elem to be given index
     * @return the calculated index
     */
    private int getListIndex(T elem) {
        int stringLength = elem.hashCode();
        int n = table.length;
        return Math.abs(stringLength % n);
    }
}


