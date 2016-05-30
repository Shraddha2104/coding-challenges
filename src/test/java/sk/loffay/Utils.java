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

    public static <T extends Comparable<T>> boolean isPostOrder(List<T> postOrder) {
        return isPostOrder(postOrder, postOrder.size());
    }

    public static <T extends Comparable<T>> boolean isPostOrder(List<T> postOrder, int length) {
        if (postOrder == null || length <= 0) {
            return false;
        }

        T root = postOrder.get(length - 1);
        int i = 0;

        // nodes on the left are less than root
        while (i < length - 1) {
            if (postOrder.get(i).compareTo(root) > 0) {
                break;
            }
            i++;
        }

        while (i < length - 1) {
            if (postOrder.get(i).compareTo(root) < 0) {
                return false;
            }
            i++;
        }

        boolean left = true;
        if (i > 0) {
            left = isPostOrder(postOrder, i);
        }

        boolean right = true;
        if (i < length - 1) {
            right = isPostOrder(postOrder.subList(i, length), length-i-1);
        }


        return left && right;
    }
}
