package sk.loffay.sort;

/**
 * @author Pavol Loffay
 *
 * Time complexity:              O(N^2)
 * Space complexity: in place    O(N), O(1)/;
 * Is stable - alg. change position of elements with the same keys
 * Online version
 * Sorting partialy sorted array does NOT require the same time as unsorted array O(nk)
 *              when each element in the input is no more than k places away from its sorted position
 *
 * More efficient in parctise than other N^2 sorting algorithms (Bubble, Selection)
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1].compareTo(arr[j]) > 0) {
                T temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
