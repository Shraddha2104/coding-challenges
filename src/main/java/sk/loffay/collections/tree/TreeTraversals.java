package sk.loffay.collections.tree;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static <Key extends Comparable<Key>, Value> List<Key> preOrderStack(TreeNode<Key, Value> node) {
        List<Key> result = new LinkedList<>();

        LinkedList<TreeNode<Key, Value>> nodesStack = new LinkedList<>();

        while (node != null) {
            result.add(node.getKey());

            node = node.getLeft() == null ? node.getRight() : node.getLeft();
            if (node == null) {
                node = nodesStack.peek() == null ? null: nodesStack.pop();
            }
        }

        return result;
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

    public static <Key extends Comparable<Key>, Value> List<Key> postOrderStack(TreeNode<Key, Value> node) {
        List<Key> postOrder = new LinkedList<>();

        LinkedList<TreeNode<Key, Value>> stack = new LinkedList<>();

        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }

        while ((node = stack.peek() != null ? stack.pop() : null) != null) {
            if (node.getRight() != null) {
                TreeNode<Key, Value> temp = node.getRight();
                while (temp != null) {
                    stack.push(temp.getRight());
                    temp = temp.getLeft();
                }
            } else {
                postOrder.add(node.getKey());
            }
        }

        return postOrder;
    }

    public static <Key extends Comparable<Key>, Value> List<Key> breadthFirstSearch(TreeNode<Key, Value> root) {
        List<Key> keys = new LinkedList<>();
        if (root != null) {
            keys = breadthFirstSearch(Arrays.asList(root));
            keys.add(0, root.getKey());
        }
        return keys;
    }

    private static <Key extends Comparable<Key>, Value> List<Key> breadthFirstSearch(List<TreeNode<Key, Value>> nodes) {

        List<Key> bfsResult = new LinkedList<>();
        List<TreeNode<Key, Value>> nextLevelNodes = new ArrayList<>(nodes.size()*2);

        for (TreeNode<Key, Value> current: nodes){
            if (current.getLeft() != null) {
                bfsResult.add(current.getLeft().getKey());
                nextLevelNodes.add(current.getLeft());
            }
            if (current.getRight() != null) {
                bfsResult.add(current.getRight().getKey());
                nextLevelNodes.add(current.getRight());
            }
        }

        if (!nodes.isEmpty()) {
            bfsResult.addAll(breadthFirstSearch(nextLevelNodes));
        }

        return bfsResult;
    }

    public static <Key extends Comparable<Key>, Value> List<Key> breadthFirstSearchIterative(TreeNode<Key, Value> root) {

        List<Key> bfsResult = new LinkedList<>();
        if (root != null) {
            LinkedList<TreeNode<Key, Value>> stack = new LinkedList<>();
            stack.add(root);

            while (!stack.isEmpty()) {
                TreeNode<Key, Value> current = stack.pollFirst();
                bfsResult.add(current.getKey());

                if (current.getLeft() != null) {
                    stack.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    stack.add(current.getRight());
                }
            }
        }

        return bfsResult;
    }
}
