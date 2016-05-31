package sk.loffay.sort;

/**
 * @author Pavol Loffay
 *
 * Time complexity:             O(N^2)
 * Space complexity: in place   O(N), O(1);
 * Not stable - alg. change position of elements with the same keys
 * Sorting partialy sorted array requires the same time as unsorted array
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
