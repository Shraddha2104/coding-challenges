package sk.loffay.collections.trie;

import java.util.LinkedList;

/**
 * @author Pavol Loffay
 */
public class RWayTrie<T> implements Trie<T>{
    // extended ASCII
    private static final int R = 256;
    private Node<T> root;

    @Override
    public void put(String key, T value) {
        root = put(root, key, value, 0);
    }

    private Node<T> put(Node<T> node, String key, T value, int d) {
        if (node == null) {
            node = new Node<>();
        }

        if (d == key.length()) {
            node.value = value;
            return node;
        }

        int index = key.charAt(d);
        node.next[index] = put(node.next[index], key, value, d + 1);

        return node;
    }

    @Override
    public T get(String key) {
        Node<T> node = get(root, key, 0);
        return node == null ? null : node.value;
    }

    private Node<T> get(Node<T> node, String key, int d) {
        if (node == null) {
            return null;
        }

        if (d == key.length()) {
            return node;
        }

        int index = key.charAt(d);
        return get(node.next[index], key, d + 1);
    }

    @Override
    public void delete(String key) {
        delete(root, key, 0);
    }

    private boolean delete(Node<T> node, String key, int d) {
        if (node == null) {
            return false;
        }

        if (d == key.length()) {
            node.value = null;
        } else if (d < key.length()) {
            int index = key.charAt(d);
            boolean deleted = delete(node.next[index], key, d + 1);
            if (deleted) {
                node.next[index] = null;
            }
        }

        boolean shouldBeRemoved = true;
        for (Node<T> nextNode: node.next) {
            if (nextNode != null) {
                return false;
            }
        }

        return shouldBeRemoved;
    }

    @Override
    public Iterable<String> keys() {
        LinkedList<String> result = new LinkedList<>();
        keys(root, "", result);
        return result;
    }

    private void keys(Node node, String str, LinkedList<String> linkedList) {
        if (node == null) {
            return;
        }

        if (node.value != null) {
            linkedList.add(str);
        }

        for (int i = 0; i < node.next.length; i++) {
            if (node.next[i] != null) {
                keys(node.next[i], str + (char)i, linkedList);
            }
        }
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        LinkedList<String> result = new LinkedList<>();
        keysWithPrefix(root, prefix, 0, false, result);
        return result;
    }

    private void keysWithPrefix(Node<T> node, String prefix, int d, boolean found, LinkedList<String> result) {
        if (node == null) {
            return;
        }

        if (d < prefix.length() && !found) {
            int index = prefix.charAt(d);
            keysWithPrefix(node.next[index], prefix, d + 1, false, result);
        } else if (found || d >= prefix.length()) {
            if (node.value != null) {
                result.add(prefix);
            }

            for (int i = 0; i < node.next.length; i++) {
                keysWithPrefix(node.next[i], prefix + (char)i, d, true, result);
            }
        }
    }

    @Override
    public Iterable<String> keysThatMatch(String regex) {
        LinkedList<String> result = new LinkedList<>();
        keysThatMatch(root, regex, 0, "", result);
        return result;
    }

    private void keysThatMatch(Node<T> node, String regex, int d, String key, LinkedList<String> result) {
        if (node == null) {
            return;
        }

        if (d == regex.length() && node.value != null) {
            result.add(key);
        }

        if (d < regex.length()) {
            // wildcard
            if (regex.charAt(d) == '.') {
                for (int i = 0; i < node.next.length; i++) {
                    keysThatMatch(node.next[i], regex, d + 1, key + (char)i, result);
                }
            } else {
                int index = regex.charAt(d);
                keysThatMatch(node.next[index], regex, d + 1, key + (char)index, result);
            }
        }
    }

    @Override
    public String longestPrefixOf(String key) {
        int prefix = longestPrefixOf(root, key, 0, 0);

        return key.substring(0, prefix);
    }

    private int longestPrefixOf(Node<T> node, String key, int d, int length) {
        if (node == null) {
            return length;
        }

        if (d == key.length()){
            return d;
        }

        char c = key.charAt(d);
        return longestPrefixOf(node.next[c], key, d + 1, d);
    }

    @Override
    public String strictLongestPrefixOf(String key) {
        return strictLongestPrefixOf(root, key, 0);
    }

    private String strictLongestPrefixOf(Node<T> node, String key, int d) {
        if (node == null) {
            return "";
        }

        if (d == key.length()) {
            return key;
        }

        String found = "";
        if (d < key.length()) {
            int index = key.charAt(d);
            found = strictLongestPrefixOf(node.next[index], key, d + 1);
        }

        if (found.isEmpty() && node.value != null) {
            return key.substring(0, d);
        }

        return found;
    }


    private static class Node<T> {
        private T value;
        private Node[] next = new Node[R];
    }
}
