package sk.loffay.netsute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class SortedCollectionTest extends TestCase {

    @Test
    public void testSortedCollection() {
        int[] values = new int[] {
                -15, -15, -11, -1, 0, 0, 53, 54, 54, 60, 60, 88, 100, 100
        };
        int[] expected = new int[] {
                -15, -11, -1, 0, 53, 54, 60, 88, 100
        };
        SortedCollection sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        values = new int[] {
                1, 1, 2, 2, 23, 42, 53, 54, 54, 60, 60, 88, 100, 100
        };
        expected = new int[] {
                1, 2, 23, 42, 53, 54, 60, 88, 100
        };
        sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        values = new int[] {
                1, 2, 2
        };
        expected = new int[] {
                1, 2
        };
        sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        values = new int[] {
                1, 1, 2
        };
        expected = new int[] {
                1, 2
        };
        sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());
    }

    @Test
    public void testCornerCases() {
        // test null
        try {
            new SortedCollection(null);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            // ok
        }

        // test empty
        SortedCollection sortedCollection = new SortedCollection(new int[0]);
        testEquals(new int[0], sortedCollection.iterator());

        // test max
        int[] values = new int[] {
                Integer.MAX_VALUE, Integer.MAX_VALUE
        };
        int[] expected = new int[] {
                Integer.MAX_VALUE
        };
        sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        // test min
        values = new int[] {
                Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        expected = new int[] {
                Integer.MIN_VALUE
        };
        sortedCollection = new SortedCollection(values);
        testEquals(expected, sortedCollection.iterator());
    }

    private static void testEquals(int[] expected, Iterator<Integer> it) {

        List<Integer> result = new ArrayList<>(expected.length);
        while (it.hasNext()) {
            result.add(it.next());
        }

        Assert.assertArrayEquals(expected, ArrayUtils.toPrimitive(result.toArray(new Integer[0])));
    }
}
