package sk.loffay.collections.tree;

/**
 * @author Pavol Loffay
 */
public interface Tree<Key extends Comparable<Key>, Value> {

    /**
     * Time:
     * average:     O(log(n)) (balanced trees)
     * worst:       O(n)
     */
    void insert(Key key, Value value);

    /**
     * Time:
     * average:     O(log(n)) (balanced trees)
     * worst:       O(n)
     */
    void delete(Key key);

    /**
     * Time:
     * average:     O(log(n)) (balanced trees)
     * worst:       O(n)
     */
    Value get(Key key);

    /**
     * Time:
     * average:     O(log(n)) (balanced trees)
     * worst:       O(n)
     */
    Value min();

    /**
     * Time:
     * average:     O(log(n)) (balanced trees)
     * worst:       O(n)
     */
    Value max();
}
