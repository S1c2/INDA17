/**
 * Created by Sabrina on 1/30/18.
 *
 * All classes that implement this interface will have to have the same methods as this interface
 */


public interface Stack<T> {
    /**
     * Adds an object to the top of the stack.
     * @param  object The object to add.
     */
    void push(T object);
    /**
     * Retrieves the object of the top of the
     * stack and removes it from the stack.
     * @return T The topmost object.
     */
    T pop();
    /**
     * Retrieves the object of the top of the
     * stack without removing it from the stack.
     * @return T The topmost object.
     */
    T top();
    /**
     * Get the size of the stack.
     * @return int The size of the stack.
     */
    int size();
    /**
     * Returns true if the stack is empty.
     * @return boolean True if empty.
     */
    boolean isEmpty();
}
