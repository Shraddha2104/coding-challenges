package sk.loffay.sort;

import java.util.Random;

/**
 * @author Pavol Loffay
 */
public class Utils {

    public static Integer[] generateArray(int size) {
        Integer[] result = new Integer[size];
        Random random = new Random();

        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(size*2);
        }

        return result;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("array is null");
        }

        T first = arr.length > 0 ? arr[0] : null;
        for (T num: arr) {
            if (first.compareTo(num) > 0) {
                return false;
            }
        }

        return true;
    }
}
