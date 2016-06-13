package sk.loffay.sort;

/**
 * Search algorithm that finds the position of a target value within a sorted array
 *
 * O(log(N)) time
 *
 * @author Pavol Loffay
 */
public class BinarySearch {

    /**
     * Returns null if value is not in the array
     */
    public static <T extends Comparable<T>> Integer search(T[] array, T value) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right-left)/2;
//            System.out.println("left= " + left + ", right= " +  right + ", middle= " + middle);

            if (value.compareTo(array[middle]) > 0) {
                left = middle + 1;
            } else if (value.compareTo(array[middle]) < 0) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return null;
    }
}
