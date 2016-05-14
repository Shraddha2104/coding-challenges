package sk.loffay.netsute;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavol Loffay
 *
 * Non recursive without parent pointers
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
            root = new Node<>(key, value);
            return;
        }

        /**
         * BST insert
         */
        List<Node<Key>> nodesToBalance = bstInsert(root, key, value);

        /**
         * fix AVL property
         */
        fixAvlProperty(nodesToBalance, key);
    }

    private void fixAvlProperty(List<Node<Key>> nodesToBalance, final Key key) {

        Node<Key> newParent = null;

        for (int i = nodesToBalance.size() - 1; i >= 0; i--) {

            Node<Key> node = nodesToBalance.get(i);

            if (newParent != null) {
                if (key.compareTo(node.key) < 0) {
                    node.left = newParent;
                } else {
                    node.right = newParent;
                }
                newParent = null;
            }

            updateHeight(node);

            int balance = getBalance(node);

            //left left
            if (balance > 1 && key.compareTo(node.left.key) < 0) {
                newParent = rightRotate(node);
            } else if (balance > 1 && key.compareTo(node.left.key) > 0) {
                node.left = leftRotate(node.left);
                newParent = rightRotate(node);
            } else if (balance < -1 && key.compareTo(node.right.key) > 0) {
                // right right
                newParent = leftRotate(node);
            } else if (balance < -1 && key.compareTo(node.right.key) < 0) {
                node.right = rightRotate(node.right);
                newParent = leftRotate(node);
            }
        }
    }

    private Node<Key> rightRotate(Node<Key> node) {
        Node<Key> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        System.out.println("Right rotate " + node.key);

        if (node == root) {
            this.root = newRoot;
        }

        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node<Key> leftRotate(Node<Key> node) {
        Node<Key> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        System.out.println("Left rotate " + node.key);

        if (node == root) {
            this.root = newRoot;
        }

        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private List<Node<Key>> bstInsert(Node<Key> node, Key key, Value value) {

        List<Node<Key>> balanceCandidates = new LinkedList<>();

        while (node != null) {
            balanceCandidates.add(node);
            Node<Key> previous = node;

            if (key.compareTo(node.key) < 0) {
                // go left
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else {
                //replace
                node.value = value;
                return Collections.emptyList();
            }

            // add new
            if (node == null) {
                Node<Key> newNode = new Node<>(key, value);
                if (key.compareTo(previous.key) < 0) {
                    previous.left = newNode;
                } else {
                    previous.right = newNode;
                }

                return balanceCandidates;
            }
        }

        return balanceCandidates;
    }

    public Node<Key> bstInsertRecursive(Node<Key> node, Key key, Value value) {
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            //go left
            if (node.left != null) {
                node = bstInsertRecursive(node.left, key, value);
            } else {
                node = (node.left = new Node<>(key, value));
            }
        } else {
            if (node.right != null) {
                node = bstInsertRecursive(node.right, key, value);
            } else {
                node = (node.right = new Node<>(key, value));
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
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node<Key> node) {
        node.height = max(height(node.left), height(node.right)) + 1;
    }

    private int height(Node<Key> node) {
        return node == null ? -1 : node.height;
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
        protected Node<Key> left;
        protected Node<Key> right;

        public Node(Key key, Value value) {
            this(key, value, null, null, 0);
        }

        public Node(Key key, Value value, Node<Key> left, Node<Key> right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public Value getValue() {
            return value;
        }

        public Key getKey() {
            return key;
        }
    }

    public boolean isBalanced(){
        return TreeBalanceCheck.checkBalance(root) != -1;
    }

    public void print() {
        new TreePrint().printNodeInternal(Collections.singletonList(root), 1, TreePrint.maxLevel(root));
    }
}
