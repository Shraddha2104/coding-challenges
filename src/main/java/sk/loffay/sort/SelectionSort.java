package sk.loffay.sort;

/**
 * @author Pavol Loffay
 *
 * Best =       N^2
 * Average =    N^2
 * Worst =      N^2
 * Space comp = 1
 * Not stable - alg. change position of elements with the same keys
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T>{

    @Override
    public void sort(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            T currentSmallest = arr[i];

            for (int j = i; j < arr.length; j++) {
                if (currentSmallest.compareTo(arr[j]) > 0) {
                    currentSmallest = arr[j];
                }
            }

            arr[i] = currentSmallest;
        }
    }
}
