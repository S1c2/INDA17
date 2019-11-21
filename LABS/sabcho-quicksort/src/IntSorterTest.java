import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Arrays;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Abstract test class for  implementations.
 *
 * Implementing test classes must override the getIntSorter method.
 *
 * @author Simon Larsén
 * @version 2018-01-16
 */
public abstract class IntSorterTest {

    /**
     * Returns an implementation of the IntSorter interface. Extending classes
     * must override this method.
     *
     * @return An implementation of Set.
     */

    protected abstract IntSorter getIntSorter();

    private static Random rand = new Random();

    //an array containing all sorters
    private IntSorter sorters[] = {
            new QuicksortFixedPivot(),
            new QuicksortFixedPivotInsertion(),
            new QuicksortRandomPivot(),
            new QuicksortRandomPivotInsertion(),
            new InsertionSort(),
            new QuicksortFixedPivot()
    };

    int nrOfSorters = sorters.length-1;

    private int arrayOfArrays[][] = new int [sorters.length][];
    //e.g arrOfArr = new int[10][5];
    //this means that the array contains 10 arrays and all those ten arrays have 5 index places
    //so basically we want to put in all sorter arrays in this array




    @Before
    public void setUp() {



    }

    public void Test(){

        //make a copy of the arrays

        for(int i = 1; i < nrOfSorters; i++){
            //create a new array with the same capacity
            arrayOfArrays[i] = new int[arrayOfArrays[0].length];
            //arraycopy(the source array, starting pos in the source array, the destination array, startpost in dest array, nr of arr elem to be copied )
            System.arraycopy(arrayOfArrays[0], 0, arrayOfArrays[i], 0, arrayOfArrays[0].length);
        }

        //sort the arrays with all sorters

        for(int i = 0; i < nrOfSorters; i++) {
            sorters[i].sort(arrayOfArrays[i]);
        }

        //assert that the arrays are equal to the sorter that passed Kattis

        for(int i = 1; i < nrOfSorters; i++) {
            assertTrue(Arrays.equals(arrayOfArrays[0], arrayOfArrays[i]));
        }

    }


    @Test
    public void emptyArray(){
        arrayOfArrays[0] = new int[0];

        Test();
    }

    @Test
    public void evenArray(){

        arrayOfArrays[0] = new int[6];
        arrayOfArrays[0][0] = 9;
        arrayOfArrays[0][1] = 11;
        arrayOfArrays[0][2] = 10;
        arrayOfArrays[0][3] = 12;
        arrayOfArrays[0][4] = 15;
        arrayOfArrays[0][5] = 20;

        Test();


    }

    @Test
    public void oddArray(){

        arrayOfArrays[0] = new int[5];
        arrayOfArrays[0][0] = 9;
        arrayOfArrays[0][1] = 11;
        arrayOfArrays[0][2] = 10;
        arrayOfArrays[0][3] = 12;
        arrayOfArrays[0][4] = 15;

        Test();

    }

    @Test
    public void ascendingSort(){
        arrayOfArrays[0] = new int[6];
        arrayOfArrays[0][0] = 9;
        arrayOfArrays[0][1] = 11;
        arrayOfArrays[0][2] = 10;
        arrayOfArrays[0][3] = 12;
        arrayOfArrays[0][4] = 15;
        arrayOfArrays[0][5] = 20;

        Test();

    }

    @Test
    public void descendingSort(){

        arrayOfArrays[0] = new int[6];
        arrayOfArrays[0][0] = 20;
        arrayOfArrays[0][1] = 15;
        arrayOfArrays[0][2] = 12;
        arrayOfArrays[0][3] = 10;
        arrayOfArrays[0][4] = 11;
        arrayOfArrays[0][5] = 9;

        Test();

    }

    @Test
    public void randomArray(){

        arrayOfArrays[0] = new int[5];
        int low = -10;
        int high = 10;

        for(int i = 0 ; i<arrayOfArrays.length-1 ; i++){
            arrayOfArrays[0][i] = rand.nextInt(high-low) + low;
        }
        Test();

    }

    @Test
    public void allElementsEqual(){

        arrayOfArrays[0] = new int[5];
        int sameNr = 2;

        for(int i = 0 ; i<arrayOfArrays.length-1 ; i++){
            arrayOfArrays[0][i] = sameNr;
        }
        Test();

    }

    @Test
    public void veryLargeArray(){

        arrayOfArrays[0] = new int[10000];

        for(int i = 0 ; i<arrayOfArrays.length-1 ; i++){
            arrayOfArrays[0][i] = rand.nextInt(10000) + -10000;
        }
        Test();

    }

}

