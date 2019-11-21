import java.util.EmptyStackException;

/**
 * The LinkedListStack class implements the interface Stack and uses the LinkedList class
 * to create a simplified linked list
 *
 * @author  Sabrina Chowdhury
 * @version 2018-01-02
 */
public class LinkedListStack<T> implements Stack<T>{
    private LinkedList<T> linkList;

    /**
     * Create a linked list to use in this stack
     */
    public LinkedListStack() {
        linkList = new LinkedList<T>();
    }

    /**
     * Adds the element to the top of the stack
     * @param  object The object to add.
     */
    public void push(T object) {
        linkList.addFirst(object);
    }

    /**
     * Removes and returns the top element in the stack,
     * that is the element that was last added to the stack
     * @return top element in the stack
     * @throws EmptyStackException
     */
    public T pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T element = linkList.removeFirst();
        return element;
    }

    /**
     * Returns the top element in the stack without removing it
     * @return top element in stack
     * @throws EmptyStackException
     */
    public T top() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        T element = linkList.getFirst();
        return element;
    }

    /**
     * The size of the stack
     * @return number of elements in the stack
     */
    public int size() {
        return linkList.size();
    }

    /**
     * indicates whether the stack is empty
     * @return true if the stack is empty and false if it is not
     */
    public boolean isEmpty() {
        return linkList.isEmpty();
    }
}


