package sk.loffay.collections;

/**
 * @author Pavol Loffay
 */
public interface Tree<Key, Value> {

    void insert(Key key, Value value);
}
