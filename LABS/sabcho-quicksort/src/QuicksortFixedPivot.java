public class QuicksortFixedPivot implements IntSorter{

    protected int getPivot(int arr[], int left, int right){
        int pivot = arr[(left + right) / 2];

        return pivot;
    }

    /**
     *
     * @param arr to be sorted
     * @param left element at beginning
     * @param right element at end
     * @return
     */
    public int partition(int arr[], int left, int right)
    {
        int i = left;
        int j = right;
        int tmp;
        int pivot = getPivot(arr,left,right);

        while (i <= j) {

            while (arr[i] < pivot)

                i++;

            while (arr[j] > pivot)

                j--;

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }

        };
        return i;

    }

    /**
     *
     * @param arr array to be sorted
     * @param left element at the beginning of the array
     * @param right element at the end of the array
     */
    public void quicksort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quicksort(arr, left, index - 1);
        if (index < right)
            quicksort(arr, index, right);

    }

    @Override
    public void sort(int[] v) {


        if(v.length>0) {
            quicksort(v, 0, v.length - 1);
        }

    }
}
