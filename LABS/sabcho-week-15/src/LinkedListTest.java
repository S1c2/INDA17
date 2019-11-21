/**
 * Test class for LinkedListStack
 * The StackTest class cannot be instantiated as it is an abstract test class and therefore
 * this class extends StackTest and instantiates an empty Stack so that we can run our tests
 *
 * @author Sabrina Chowdhury
 * @version 2018-01-02
 */

public class LinkedListTest<T> extends StackTest<T>{

    protected Stack<Integer> getIntegerStack(){

        return new LinkedListStack<Integer>();
    }

}
