package sk.loffay.collections;

/**
 * @author Pavol Loffay
 */
public interface Tree<Key extends Comparable<Key>, Value> {

    /**
     * Time:
     * height of the tree: can be O(N) or when the tree is balanced O(log(N)) (AVL, red-black trees)
     */
    void insert(Key key, Value value);

    /**
     * Time:
     * height of the tree: can be O(N) or when the tree is balanced O(log(N)) (AVL, red-black trees)
     */
    void delete(Key key);

    /**
     * height of the tree: can be O(N) or when the tree is balanced O(log(N)) (AVL, red-black trees)
     */
    Value get(Key key);

    /**
     * height of the tree: can be O(N) or when the tree is balanced O(log(N)) (AVL, red-black trees)
     */
    Value min();

    /**
     * height of the tree: can be O(N) or when the tree is balanced O(log(N)) (AVL, red-black trees)
     */
    Value max();
}
