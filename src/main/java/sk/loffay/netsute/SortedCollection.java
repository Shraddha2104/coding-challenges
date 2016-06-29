package sk.loffay.netsute;

import java.util.Iterator;

/**
 * @author Pavol Loffay
 *
 * QUESTION 1 B
 * 6. Does your implementation work for generic objects, numbers, or integers?
 * 7. If it does not work with objects, what would be required to make it work
 * for generic objects?
 *
 * 6: It does not work for generic objects, only for integers
 * 7: It could work for class extending java.lang.Numer
 */
public class SortedCollection implements Iterable<Integer> {

    private int[] values;

    private int index;
    private int previous;

    public SortedCollection(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Cannot remove duplicates from null.");
        }

        // copy
        this.values = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (i > 0 && values[i] < values[i - 1]) {
                throw new IllegalArgumentException("Array is not sorted");
            }

            this.values[i] = values[i];
        }

        this.index = 0;
        // change first value
        this.previous = values.length > 0 ? values[0] >> 1 : 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {

                for (int i = index; i < values.length; i++) {
                    if (values[i] != previous) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Integer next() {

                for (int i = index; i < values.length; i++) {
                    if (values[i] != previous) {
                        previous = values[i];
                        index = i;
                        return previous;
                    }
                }

                return null;
            }
        };
    }
}
