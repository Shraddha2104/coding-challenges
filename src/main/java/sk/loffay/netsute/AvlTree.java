package sk.loffay.netsute;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pavol Loffay
 *
 * with parent pointers
 */
public class AvlTree<Key extends Comparable<Key>, Value> implements Tree<Key, Value> {

    private Node<Key> root;

    public AvlTree() {
    }

    public void insert(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Null key are not allowed");
        }
        if (root == null) {
            root = new Node<>(key, value, null);
            return;
        }

        /**
         * BST insert
         */
        Node<Key> added = bstInsert(root, key, value);

        /**
         * fix AVL property
         */
        fixAvlProperty(added.parent, key, 1);
    }

    private void fixAvlProperty(Node<Key> node, Key key, int height) {

        while (node != null) {
            node.height = height++;
            int balance = getBalance(node);

            Node<Key> newParent = null;

            //left left
            if (balance > 1 && key.compareTo(node.left.key) < 0) {
                newParent = rightRotate(node);
            } else if (balance > 1 && key.compareTo(node.left.key) > 0) {
                node.left = leftRotate(node.left);
                newParent = rightRotate(node);
            } else if (balance < 0 && key.compareTo(node.right.key) > 0) {
                // right right
                newParent = leftRotate(node);
            } else if (balance < 0 && key.compareTo(node.right.key) < 0) {
                node.right = rightRotate(node.right);
                newParent = leftRotate(node);
            }

            if (newParent != null && newParent.parent != null) {
                if (key.compareTo(node.parent.key) < 0) {
                    newParent.parent.left = newParent;
                } else {
                    newParent.parent.right = newParent;
                }
            }

            node = node.parent;
        }
    }

    private Node<Key> rightRotate(Node<Key> node) {
        Node<Key> newRoot = node.left;
        if (node == root) {
            root = newRoot;
        }
        newRoot.parent = node.parent;
        node.parent = newRoot;

        node.left = newRoot.right;
        newRoot.right = node;

        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        node.height = max(height(node.left), height(node.right)) + 1;
        return newRoot;
    }

    private Node<Key> leftRotate(Node<Key> node) {
        Node<Key> newRoot = node.right;
        if (node == root) {
            root = newRoot;
        }
        newRoot.parent = node.parent;
        node.parent = newRoot;

        node.right = newRoot.left;
        newRoot.left = node;

        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;
        node.height = max(height(node.left), height(node.right)) + 1;
        return newRoot;
    }


    private Node<Key> bstInsert(Node<Key> node, Key key, Value value) {

        while (node != null) {
            Node<Key> previous = node;

            if (key.compareTo(node.key) < 0) {
                // go left
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                //replace
                node.value = value;
            }

            // add new
            if (node == null) {
                Node<Key> newNode = new Node<>(key, value, previous);
                if (key.compareTo(previous.key) < 0) {
                    previous.left = newNode;
                } else {
                    previous.right = newNode;
                }

                return newNode;
            }
        }

        return node;
    }

    public Node<Key> bstInsertRecursive(Node<Key> node, Key key, Value value) {
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            //go left
            if (node.left != null) {
                node = bstInsertRecursive(node.left, key, value);
            } else {
                node = (node.left = new Node<>(key, value, node));
            }
        } else {
            if (node.right != null) {
                node = bstInsertRecursive(node.right, key, value);
            } else {
                node = (node.right = new Node<>(key, value, node));
            }
        }

        return node;
    }

    public void inOrderPrint() {
        inOrderPrint(root);
    }

    private void inOrderPrint(Node<Key> node) {
        if (node != null) {
            inOrderPrint(node.left);
        }

        if (node != null) {
            System.out.println("Key: " + node.key + " ,value: " + node.value);
            inOrderPrint(node.right);
        }
    }

    private int getBalance(Node<Key> node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    private int height(Node<Key> node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public void delete(Key key) {
        throw new UnsupportedOperationException();
    }

    public class Node<Key extends Comparable<Key>> {

        private Value value;
        private Key key;

        private int height;
        private Node<Key> parent;
        private Node<Key> left;
        private Node<Key> right;

        public Node(Key key, Value value, Node<Key> parent) {
            this(key, value, parent, null, null, 0);
        }

        public Node(Key key, Value value, Node<Key> parent, Node<Key> left, Node<Key> right, int height) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    public boolean isBalanced(){
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node<Key> node){
        if (node == null) return 0;
        int left = checkBalance(node.left);

        if (left == -1) return -1;

        int right = checkBalance(node.right);

        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }

    public void print() {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private void printNodeInternal(List<Node<Key>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<Key>> newNodes = new ArrayList<Node<Key>>();
        for (Node<Key> node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Node<Key> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
