/**
 * Created by Sabrina on 2/28/18.
 */
public class QuicksortFixedPivotInsertion extends QuicksortFixedPivot{


    /**
     * Quicksort for a fixed pivot. Uses insertion sort for smaller arrays
     *
     */
    public void sort(int[] v, int first, int last){
        if(first >= last)
            return;

        // use insertion sort for smaller array
        if(last-first <= 16){
            insertionSort(v, first, last);
            return;
        }

        quicksort(v,first,last);
    }

    /**
     *
     * @param v array to be sorted
     * @param first first element in array
     * @param last last element in array
     */
    private void insertionSort(int[] v, int first, int last){
        for(int i = first+1; i < last+1; ++i){
            if(v[i-1]>v[i]){
                int tmp = v[i];

                int j = i;

                while(j > 0 && v[j-1] > tmp){
                    v[j] = v[--j];
                }
                v[j] = tmp;
            }
        }
    }
}
