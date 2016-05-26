package sk.loffay.artin;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import sk.loffay.Utils;

/**
 * @author Pavol Loffay
 */
public class PancakeSortTest {

    @Test
    public void testPancakeSort() {
        int[] array = new int[] {3, 4, 5, 7, 7, 1, 3, 0, -99};
        int[] array2 = {1, 8, 9, 11};

        array2[2] = 2;
        int[] array3 = new int[3];

        System.out.println("length = " + array.length);
        System.out.println("length = " + array2[2]);
        System.out.println("length = " + array3.length);

        System.out.println("Result: ");
//        for (Integer revers: PancakeSort.pancakeSort(array)) {
//            System.out.println(revers);
//        }

        Assert.assertTrue(Utils.isSorted(Arrays.stream(array).boxed().collect(Collectors.toList()), false));
        System.out.println(Arrays.toString(array));
    }
}
