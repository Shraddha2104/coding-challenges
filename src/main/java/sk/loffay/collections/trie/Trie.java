package sk.loffay.collections.trie;

/**
 * In nodes are stored characters not the whole keys
 * Each node can have multiple children - there can be lots of null links (see ternary trie)
 *
 * Keys are implicitly stored in links
 *
 * Applications:
 *      - spell check (26 way trie)
 *      - helper in googole input search (prefix search)
 *      - T9 helper
 *
 * @author Pavol Loffay
 */
public interface Trie<T> {

    void put(String key, T value);

    T get(String key);

    void delete(String key);

    Iterable<String> keys();
    Iterable<String> keysWithPrefix(String prefix);
    /**
     * regex:
     * [a-z]+
     * . - any character
     */
    Iterable<String> keysThatMatch(String regex);
    String longestPrefixOf(String key);
    String strictLongestPrefixOf(String key);
}
