package sk.loffay;

import java.util.List;

/**
 * @author Pavol Loffay
 */
public class Utils {

    public static <T extends Comparable<T>> boolean isSorted(List<T> values, boolean ascending) {

        Comparable<? extends T> previous = null;

        for(Comparable val: values) {

            if (previous != null) {
                boolean result = ascending ? val.compareTo(val) > 0 : val.compareTo(val) < 0;
                if (result) {
                    return false;
                }
            }

            previous = val;
        }

        return true;
    }

}
