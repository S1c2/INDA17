import java.io.*;
import java.util.*;

/**
 * An example demonstrating the effects of just-in-time compilation
 * on time measurements.
 *
 * @author Stefan Nilsson
 * @version 2011-02-07
 */
public final class TimingExample {

    private static Random rand = new Random();


    //an array containing all sorters
    private static IntSorter sorters[] = {
            new QuickSortJava(),
            new QuicksortFixedPivot(),
            new QuicksortFixedPivotInsertion(),
            new QuicksortRandomPivot(),
            new QuicksortRandomPivotInsertion(),
            new InsertionSort(),
    };

    private static String sorterName[] =
            {"Java Built In QuickSort",
                    "Fixed Pivot",
                    "Fixed Pivot Insertion",
                    "Random Pivot",
                    "Random Pivot Insertion",
                    "Insertion Sort"};

    static int nrOfSorters = sorters.length-1;

    private static int arrayOfArrays[][] = new int [sorters.length][];
    //e.g arrOfArr = new int[10][5];
    //this means that the array contains 10 arrays and all those ten arrays have 5 index places
    //so basically we want to put in all sorter arrays in this array


    private static void copyFilledListToRestOfLists() {

        for (int i = 1; i <= nrOfSorters; i++) {
            //create a new array with the same capacity
            arrayOfArrays[i] = new int[arrayOfArrays[0].length];
            //arraycopy(the source array, starting pos in the source array, the destination array, startpost in dest array, nr of arr elem to be copied )
            System.arraycopy(arrayOfArrays[0], 0, arrayOfArrays[i], 0, arrayOfArrays[0].length);
        }

    }

    private static void sort(int n){


        Stopwatch s = new Stopwatch();

        for(int j = 0; j <= nrOfSorters; ++j){
            long totalTime = 0;
            long averageTime = 0;
            long[] timesArray = new long[n+1];
            long highest = 0;
            long lowest = 0;
            for(int i = 1; i<=n ; i++ ) {
                s.reset();
                s.start();
                sorters[j].sort(arrayOfArrays[j]);
                s.stop();
                //System.out.println(sorterName[j] + ": " + s.toString());
                totalTime = totalTime + s.nanoseconds();
                timesArray[i] = s.nanoseconds();

            }
            averageTime = totalTime/n;
            Arrays.sort(timesArray);
            highest = timesArray[timesArray.length-1];
            lowest = timesArray[1];


            System.out.println("\nAverage time using " + n + " trials for " + sorterName[j] + ": " +  averageTime + "\nMax time = " + highest + "\nMin time = " + lowest);


        }
    }


    private static void runAlgos(){

        for(int i = 0; i < nrOfSorters; ++i){

            arrayOfArrays[0] = new int[1000000];

            for(int j = 0; j < 1000000; ++j){
                arrayOfArrays[0][j] = rand.nextInt();
            }

            copyFilledListToRestOfLists();
            sort(20);//if you want to warm up the machine longer, you increase the number
        }


    }

    /**
     * If you're using a JVM with just-in-time compilation,
     * chanses are that the first reported time is much
     * larger than the rest: during most of the first
     * invocation of the sum() method, the code has yet
     * to be compiled and optimized.
     */
    public static void main(String[] args)throws FileNotFoundException {

        int numberOfTrials = 100;

        int[] ArraySizes = new int[]{100,1000,10000,100000,1000000};

        System.out.println("Just warming up the machine");
        runAlgos();
        System.out.println("Finished warming up:)");
        for(int i = 0; i<10;i++) {
            System.out.println();
        }

        //sorted list of given sizes
        for(int size : ArraySizes) {

            System.out.println("\nSorted list, " + size + "elements:\n");
            arrayOfArrays[0] = new int[size];

            for (int j = 0; j < size; ++j) {
                arrayOfArrays[0][j] = j;
            }

            copyFilledListToRestOfLists();
            sort(numberOfTrials);
        }

        //reversely sorted list of given sizes

        for(int size : ArraySizes) {

            System.out.println("\nReversely sorted list," +  size + "elements:\n");
            arrayOfArrays[0] = new int[size];

            for (int j = 0; j < size; ++j) {
                arrayOfArrays[0][j] = size - j;
            }

            copyFilledListToRestOfLists();
            sort(numberOfTrials);
        }


        //list of given sizes with equal elements

        for(int size : ArraySizes) {


            System.out.println("\nSame value, " + size + " elements:\n");
            arrayOfArrays[0] = new int[size];

            for (int j = 0; j < size; ++j) {
                arrayOfArrays[0][j] = 42;
            }

            copyFilledListToRestOfLists();
            sort(numberOfTrials);
        }

        //Random list with given sizes

        for(int size : ArraySizes) {
            System.out.println("\nRandom list, " + size + " elements:\n");
            arrayOfArrays[0] = new int[size];

            for (int j = 0; j < size; ++j) {
                arrayOfArrays[0][j] = rand.nextInt();
            }

            copyFilledListToRestOfLists();
            sort(numberOfTrials);
        }

    }

}


