package sk.loffay.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class BinarySearchTest {

    @Test
    public void test() {
        Integer[] arr = new Integer[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        Assert.assertEquals(null, BinarySearch.search(arr, 10));
        Assert.assertEquals(new Integer(5), BinarySearch.search(arr, 6));
        Assert.assertEquals(new Integer(8), BinarySearch.search(arr, 9));
        Assert.assertEquals(new Integer(1), BinarySearch.search(arr, 2));
        Assert.assertEquals(new Integer(0), BinarySearch.search(arr, 1));
    }
}
