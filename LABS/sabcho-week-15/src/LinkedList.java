/**
 * A singly linked list.
 *
 * @author (Sabrina Chowdhury)
 * @version (23-01-2018)
 */


import java.util.NoSuchElementException;


public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    public int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0; // the linked list is dynamic (size-wise) and so can adjust in size
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {

        ListElement<T> firstElement = new ListElement<T>(element);

        if (element == null)
            //already the default value

            return;

        else {

            if (this.first == null) {

                this.last = firstElement;

            } else {

                ListElement<T> previousFirst = this.first;

                firstElement.next = previousFirst;

            }

        }

        this.first = firstElement;
        this.size += 1;
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        ListElement<T> lastElement = new ListElement<T>(element);
        ListElement<T> previousLast = this.last;
        if(previousLast != null) {
            previousLast.next = lastElement;
        }
        else {
            //List contains no elements, set first element as well.
            this.first = lastElement;
        }

        this.last = lastElement;
        this.size += 1;
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        if(this.first != null) {
            return this.first.data;
        }
        else{
            throw new NoSuchElementException();
        }

    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {

        if(this.last != null) {
            return this.last.data;
        }
        else{
            throw new NoSuchElementException();
            //throw exception if the last element is null
            //which is only possible when the list is empty
        }


    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        if(index > size-1 ) {
            throw new IndexOutOfBoundsException();
            //throw exception when the index is larger than the actual size of the list, not possible
        }
        if(index<0){
            throw new IndexOutOfBoundsException();
            //throw exception when index is smaller than 0, not possible
        }

        int currentIndex = 0;
        //we will increment "currentIndex by 1 for each iteration"
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(currentIndex == index) {
                return element.data;
            }
            currentIndex += 1;
        }
        return null;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        ListElement<T> firstElement = this.first;
        if(firstElement != null) { //if there is actually something there in the first place
            ListElement<T> nextElement = firstElement.next;
            this.first = nextElement; //we assign the second element to be the new first element
            this.size -= 1; //the size is decreased by 1 because we just removed one element
            if(this.size == 0) { //and if the size is now 0, which would mean that our list only had one element
                this.last = null; // this means that this is now an empty list
            }
            return firstElement.data;
        }
        else{
            throw new NoSuchElementException(); //if the list is empty, we throw an exception
        }

    }

    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        return this.size;

    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {

        if(this.size==0) {
            //by definition, but would be nicer to just write, if (this.size==0)
            return true;
        }
        return false;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        String outputString = "["; // [
        for(ListElement<T> element = this.first; element != null; element = element.next) {
            if(element.data == null) {
                outputString += "null";
            }
            else {
                outputString += element.data.toString();
            }
            //There is no comma after the last element, so we always check that there is a next element
            if(element.next != null) {
                outputString += ", ";
            }
        }
        outputString += "]";
        return outputString;
    }



}