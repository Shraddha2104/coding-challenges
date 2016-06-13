package sk.loffay.collections;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class AvlTree<Key extends Comparable<Key>, Value> implements Tree<Key, Value> {

    private Node<Key, Value> root;

    public Node<Key, Value> getRoot() {
        return root;
    }

    /**
     * Non recursive insert
     */
    @Override
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
        List<Node<Key, Value>> nodesToBalance = bstInsert(root, key, value);

        /**
         * fix AVL property
         */
        fixAvlProperty(nodesToBalance, key);
    }

    @Override
    public Value min() {
        if (root == null) {
            return null;
        }

        TreeNode<Key, Value> temp = root;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp.getValue();
    }

    @Override
    public Value max() {
        if (root == null) {
            return null;
        }

        TreeNode<Key, Value> temp = root;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        return temp.getValue();
    }

    @Override
    public Value get(Key key) {
        if (root == null) {
            return null;
        }

        TreeNode<Key, Value> temp = root;
        while (temp != null) {
            if (temp.getKey().compareTo(key) == 0) {
                return temp.getValue();
            }

            if (key.compareTo(temp.getKey()) < 0) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }

        return null;
    }

    @Override
    public void delete(Key key) {
        throw new UnsupportedOperationException();
    }

    private void fixAvlProperty(List<Node<Key, Value>> nodesToBalance, final Key key) {

        Node<Key, Value> newParent = null;

        for (int i = nodesToBalance.size() - 1; i >= 0; i--) {

            Node<Key, Value> node = nodesToBalance.get(i);

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

    private Node<Key, Value> rightRotate(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.left;
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

    private Node<Key, Value> leftRotate(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.right;
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

    public void insertRecursive(Key key, Value value) {
        root = insertRecursive(root, key, value);
    }

    public Node<Key, Value> insertRecursive(Node<Key, Value> node, Key key, Value value) {

        // insert
        if (node == null) {
            return new Node<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRecursive(node.right, key, value);
        }

        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1) {
            if (key.compareTo(node.left.key) < 0) {
                // left left
                node = rightRotate(node);
            } else if (key.compareTo(node.left.key) > 0) {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            if (key.compareTo(node.right.key) > 0) {
                // right right
                node = leftRotate(node);
            } else if (key.compareTo(node.right.key) < 0) {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }

        return node;
    }

    /**
     * @param node - root
     * @param key
     * @param value
     * @return nodes from root to the added leaf, on these nodes should be checked AVL property
     *                                                                  (if the tree is balanced)
     */
    private List<Node<Key, Value>> bstInsert(Node<Key, Value> node, Key key, Value value) {

        List<Node<Key, Value>> balanceCandidates = new LinkedList<>();

        while (node != null) {
            balanceCandidates.add(node);
            Node<Key, Value> previous = node;

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
                Node<Key, Value> newNode = new Node<>(key, value);
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

    private int getBalance(Node<Key, Value> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node<Key, Value> node) {
        node.height = max(height(node.left), height(node.right)) + 1;
    }

    private int height(Node<Key, Value> node) {
        return node == null ? -1 : node.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }


    public static class Node<Key extends Comparable<Key>, Value> implements TreeNode<Key, Value>{

        private Value value;
        private Key key;

        private int height;
        protected Node<Key, Value> left;
        protected Node<Key, Value> right;

        public Node(Key key, Value value) {
            this(key, value, null, null, 0);
        }

        public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        @Override
        public Value getValue() {
            return value;
        }

        @Override
        public void setValue(Value value) {
            this.value = value;
        }

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public Node<Key, Value> getLeft() {
            return left;
        }

        @Override
        public Node<Key, Value> getRight() {
            return right;
        }
    }

    public boolean isBalanced(){
        return TreeBalanceCheck.checkBalance(root) != -1;
    }

    public void print() {
        TreePrint.printNodeInternal(Collections.singletonList(root), 1, TreePrint.maxLevel(root));
    }
}
