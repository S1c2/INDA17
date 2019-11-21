

/**
 * Created by Sabrina on 2/28/18.
 */
public class InsertionSort implements IntSorter{

    public void sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int index = i;
            while(index>0 && array[index-1]>(array[index])){
                int temp = array[index];
                array[index] = array[index-1];
                array[index-1] = temp;
                index = index - 1;
            }
        }
    }

}
