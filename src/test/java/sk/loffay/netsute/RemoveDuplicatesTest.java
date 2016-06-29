package sk.loffay.netsute;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        int[] values = new int[]{
                1,2,3
        };
        int[] expected = new int[] {
                1, 2, 3};

        int[] withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        values = new int[] {
                1
        };
        expected = new int[] {
                1
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        values = new int[] {
                1, 1, 2
        };
        expected = new int[] {
                1, 2
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        values = new int[] {
                1, 2, 2
        };
        expected = new int[] {
                1, 2
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        values = new int[] {
                1, 1, 2, 2
        };
        expected = new int[] {
                1, 2
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        values = new int[] {
                1, 1, 2, 2, 23, 42, 53, 54, 54, 60, 60, 88, 100, 100
        };
        expected = new int[] {
                1, 2, 23, 42, 53, 54, 60, 88, 100
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        // negative values
        values = new int[] {
                -15, -15, -11, -1, 0, 0, 53, 54, 54, 60, 60, 88, 100, 100
        };
        expected = new int[] {
                -15, -11, -1, 0, 53, 54, 60, 88, 100
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        // unsorted
        values = new int[] {
                1, 1, 2, 2, 23, 42, 53, 54, 53, 60, 60, 88, 100, 100
        };
        try {
            RemoveDuplicates.removeDuplicates(values);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            // ok
        }
        // unsorted 2
        values = new int[] {
                1, 0, 2, 2, 23, 42, 53, 54, 53, 60, 60, 88, 100, 100
        };
        try {
            RemoveDuplicates.removeDuplicates(values);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            // ok
        }
    }

    @Test
    public void testCornerCases() {
        // test null
        try {
            RemoveDuplicates.removeDuplicates(null);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            // ok
        }

        // test empty
        int[] withoutDuplicates = RemoveDuplicates.removeDuplicates(new int[0]);
        Assert.assertArrayEquals(new int[0], withoutDuplicates);

        // test max
        int[] values = new int[] {
                Integer.MAX_VALUE, Integer.MAX_VALUE
        };
        int[] expected = new int[] {
                Integer.MAX_VALUE
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);

        // test min
        values = new int[] {
                Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        expected = new int[] {
                Integer.MIN_VALUE
        };
        withoutDuplicates = RemoveDuplicates.removeDuplicates(values);
        Assert.assertArrayEquals(expected, withoutDuplicates);
    }
}
