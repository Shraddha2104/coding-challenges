package sk.loffay.netsute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class GenericSortedCollectionTest {

    @Test
    public void testSortedCollection() {
        Integer[] values = new Integer[] {
                -15, -15, -11, -1, 0, 0, 53, 54, 54, 60, 60, 88, 100, 100
        };
        Integer[] expected = new Integer[] {
                -15, -11, -1, 0, 53, 54, 60, 88, 100
        };
        GenericSortedCollection<Integer> sortedCollection = new GenericSortedCollection<>(values);
        testEquals(expected, sortedCollection.iterator());

        values = new Integer[] {
                1, 1, 2, 2, 23, 42, 53, 54, 54, 60, 60, 88, 100, 100
        };
        expected = new Integer[] {
                1, 2, 23, 42, 53, 54, 60, 88, 100
        };
        sortedCollection = new GenericSortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        values = new Integer[] {
                1, 2, 2
        };
        expected = new Integer[] {
                1, 2
        };
        sortedCollection = new GenericSortedCollection(values);
        testEquals(expected, sortedCollection.iterator());

        values = new Integer[] {
                1, 1, 2
        };
        expected = new Integer[] {
                1, 2
        };
        sortedCollection = new GenericSortedCollection(values);
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
        GenericSortedCollection<Integer> genericSortedCollection = new GenericSortedCollection(new Integer[0]);
        testEquals(new Integer[0], genericSortedCollection.iterator());

        // test max
        Integer[] values = new Integer[] {
                Integer.MAX_VALUE, Integer.MAX_VALUE
        };
        Integer[] expected = new Integer[] {
                Integer.MAX_VALUE
        };
        genericSortedCollection = new GenericSortedCollection<>(values);
        testEquals(expected, genericSortedCollection.iterator());

        // test min
        values = new Integer[] {
                Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        expected = new Integer[] {
                Integer.MIN_VALUE
        };
        genericSortedCollection = new GenericSortedCollection<>(values);
        testEquals(expected, genericSortedCollection.iterator());
    }

    @Test
    public void testDouble() {
        Double[] values = new Double[] {
                -15.1, -15.1, -11.5, -1.4, 0.5, 0.5, 53.5, 54.6, 54.6, 60.7, 60.7, 88.8, 100.9, 100.9
        };
        Double[] expected = new Double[] {
                -15.1, -11.5, -1.4, 0.5, 53.5, 54.6, 60.7, 88.8, 100.9
        };

        GenericSortedCollection<Double> genericSortedCollection = new GenericSortedCollection<>(values);
        testEquals(expected, genericSortedCollection.iterator());
    }

    private static void testEquals(Number[] expected, Iterator<? extends Number> it) {

        List<Number> result = new ArrayList<>(expected.length);
        while (it.hasNext()) {
            result.add(it.next());
        }

        Assert.assertArrayEquals(expected, result.toArray(new Number[0]));
    }
}
