package sk.loffay.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class TreeTraversals {

    public static <Key extends Comparable<Key>, Value> void preOrder(TreeNode<Key, Value> node, List<Key> result) {
        if (node != null) {
            result.add(node.getKey());
            preOrder(node.getLeft(), result);
            preOrder(node.getRight(), result);
        }
    }

    public static <Key extends Comparable<Key>, Value> List<Key> preOrder(TreeNode<Key, Value> node) {
        if (node != null) {
            List<Key> preOrder = new LinkedList<>();

            preOrder.add(node.getKey());
            preOrder.addAll(preOrder(node.getLeft()));
            preOrder.addAll(preOrder(node.getRight()));

            return preOrder;
        } else {
            return Collections.emptyList();
        }
    }

    public static <Key extends Comparable<Key>, Value> List<Key> inOrder(TreeNode<Key, Value> node) {
        if (node != null) {
            List<Key> inOrderList = new LinkedList<>();

            inOrderList.addAll(inOrder(node.getLeft()));
            inOrderList.add(node.getKey());
            inOrderList.addAll(inOrder(node.getRight()));

            return inOrderList;
        } else {
            return Collections.emptyList();
        }
    }

    public static <Key extends Comparable<Key>, Value> void inOrder(TreeNode<Key, Value> node, List<Key> inOrderList) {
        if (node != null) {
            inOrder(node.getLeft(), inOrderList);
            inOrderList.add(node.getKey());
            inOrder(node.getRight(), inOrderList);
        }
    }

    public static <Key extends Comparable<Key>, Value> List<Key> inOrderStack(TreeNode<Key, Value> node) {

        LinkedList<TreeNode<Key, Value>> stack = new LinkedList<>();
        List<Key> inOrder = new LinkedList<>();

        // go to left
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        // pop and if there is right go (right one and all down left)
        while (stack.size() > 0) {
            node = stack.pop();

            inOrder.add(node.getKey());

            if (node.getRight() != null) {
                node = node.getRight();
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
            }
        }

        return inOrder;
    }

    public static <Key extends Comparable<Key>, Value> List<Key> postOrder(TreeNode<Key, Value> node) {
        if (node != null) {
            List<Key> postOrderList = new LinkedList<>();

            postOrderList.addAll(inOrder(node.getLeft()));
            postOrderList.addAll(inOrder(node.getRight()));
            postOrderList.add(node.getKey());

            return postOrderList;
        } else {
            return Collections.emptyList();
        }
    }

    public static <Key extends Comparable<Key>, Value> void postOrder(TreeNode<Key, Value> node,
                                                                      List<Key> postOrderList) {
        if (node != null) {
            inOrder(node.getLeft(), postOrderList);
            inOrder(node.getRight(), postOrderList);
            postOrderList.add(node.getKey());
        }
    }
}
