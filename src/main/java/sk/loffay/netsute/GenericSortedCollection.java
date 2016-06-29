package sk.loffay.netsute;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Pavol Loffay
 */
public class GenericSortedCollection<T extends Number> implements Iterable<T> {

    private T[] values;

    private int index;
    private T previous;

    public GenericSortedCollection(T[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Cannot remove duplicates from null.");
        }

        // copy and check if it is ordered
        this.values = Arrays.copyOf(values, values.length);
        for (int i = 0; i < values.length; i++) {
            if (i > 0 && values[i].longValue() < values[i - 1].longValue()) {
                throw new IllegalArgumentException("Array is not sorted");
            }

            this.values[i] = values[i];
        }

        this.index = 0;
        // change first value
        this.previous = (T) (values.length > 0 ? new Long(values[0].intValue() >> 1) : new Long(0));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {

            @Override
            public boolean hasNext() {

                for (int i = index; i < values.length; i++) {
                    if (!values[i].equals(previous)) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public T next() {

                for (int i = index; i < values.length; i++) {
                    if (!values[i].equals(previous)) {
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
