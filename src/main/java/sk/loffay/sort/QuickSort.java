package sk.loffay.sort;

/**
 * Best =       N
 * Average =    N*log(N)
 * Worst =      N^2
 * Space comp = log(n)
 * Not Stable - alg. does change position of elements with the same keys
 * Typically in place is not stable, stable versions exists
 *
 * The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch.
 * This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to
 * quadratic performance, and is typically faster than traditional (one-pivot) Quicksort implementations.
 *
 * pivot = pseudo median = the central point, pin, or shaft on which a mechanism turns or oscillates.
 *
 * @author Pavol Loffay
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int left, int right) {

        int middle = left + (right - left)/2;
        T pivot = arr[middle];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }
            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(arr, left, j);
        }

        if (right > i) {
            quickSort(arr, i, right);
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
