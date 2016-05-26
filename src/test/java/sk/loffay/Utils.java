package sk.loffay;

import java.util.List;
import java.util.Stack;

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

    public static <T extends Comparable<T>> boolean isPreOrder(List<T> preOrder) {

        Stack<Comparable<T>> stack = new Stack<>();
        Comparable<T> lower = null;

        for(int i = 0; i < preOrder.size() ;i++) {
            if(lower != null && lower.compareTo(preOrder.get(i)) > 0) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek().compareTo(preOrder.get(i)) < 0) {
                lower = stack.pop();
            }
            stack.push(preOrder.get(i));
        }

        return true;
    }
}
