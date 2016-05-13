package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 */
public interface Tree<Key, Value> {

    void insert(Key key, Value value);
}
