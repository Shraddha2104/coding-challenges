package sk.loffay.collections.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pavol Loffay
 */
public class TreeTestUtils {

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

    public static <Key extends Comparable<Key>, Value> boolean isValidBst(TreeNode<Key, Value> node) {

        LinkedList<TreeNode<Key, Value>> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        Key currentKey = null;
        while (!stack.isEmpty()) {
            node = stack.pop();

            if (currentKey != null && currentKey.compareTo(node.getKey()) > 0) {
                return false;
            }
            currentKey = node.getKey();

            // go right is necessary
            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }

        return true;
    }
}
