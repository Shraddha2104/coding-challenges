package sk.loffay.collections.tree;

/**
 * @author Pavol Loffay
 */
public interface TreeNode<Key extends Comparable<Key>,  Value>{

    Key getKey();

    Value getValue();

    void setValue(Value value);

    TreeNode<Key, Value> getLeft();
    TreeNode<Key, Value> getRight();
}
