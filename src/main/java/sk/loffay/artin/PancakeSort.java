package sk.loffay.artin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavol on 16.1.2015.
 */
public class PancakeSort {

    /**
     * Uloha 4
     *
     * Implementujte funkciu reverseSort(pancakeSort), ktora funguje na principe
     * revertovania lubovolneho poctu prvkou od zaciatku pola. To znamena ze na usporiadenie
     * pola mozte iba otacat poradie N prvkov od zaciatku (indexu 0). Funkcia ma vratit
     * pole, ktore bude obsahovat jednotlivy pocet otocenych prvkov.
     *
     * 1) [1,2,7,1]
     * 2) [7,2,1,1]
     * 3) [1,1,2,7] koniec - V tomto pripade funkcia vrati [3, 4]
     *
     *
     * @param array
     * @return pocet presunov od zaciatku
     */
    public static List<Integer> pancakeSort(int[] array) {

        List<Integer> ret = new ArrayList<>();

        for (int i = array.length - 1; i > 0; i--) {

            int positionOfBiggestValue = positionOfBiggestValue(array, i);
            if (positionOfBiggestValue == i) {
                continue;
            }

            reverseOrder(array, positionOfBiggestValue);
            reverseOrder(array, i);

            // position != element count
            ret.add(positionOfBiggestValue + 1);
            ret.add(i + 1);
        }

        return ret;
    }

    private static int[] reverseOrder(int[] arr, int toPosition) {

        if (toPosition > arr.length - 1) {
            throw new IndexOutOfBoundsException("toPosition has to be less then array length");
        }

        for (int i = 0; i < (toPosition + 1) / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[toPosition - i];
            arr[toPosition - i] = tmp;
        }

        return arr;
    }

    private static int positionOfBiggestValue(int[] array, int endPosition) {

        if (endPosition >= array.length) {
            throw new IndexOutOfBoundsException("endPosition is bigger than array length");
        }

        int pos = endPosition;
        int max = Integer.MIN_VALUE;
        for (int i = endPosition; i >= 0; i--) {
            if (array[i] > max) {
                max = array[i];
                pos = i;
            }
        }

        return pos;
    }
}
