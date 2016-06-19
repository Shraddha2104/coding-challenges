package sk.loffay.collections.trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class RWayTrieTest {

    @Test
    public void test() {
        RWayTrie<Integer> trie = new RWayTrie<>();

        trie.put("hello", 1);
        trie.put("day", 1);
        trie.put("dream", 1);
        trie.put("night", 1);
        trie.put("nirvana", 1);
        trie.put("zero", 1);
        trie.put("fero", 1);

        LinkedList<String> words = new LinkedList<>();
        trie.keys().forEach(words::add);
        Assert.assertTrue(words.size() == 7);

        // prefix
        words.clear();
        trie.keysWithPrefix("d").forEach(words::add);
        Assert.assertTrue(words.size() == 2);
        words.clear();
        trie.keysWithPrefix("da").forEach(words::add);
        Assert.assertTrue(words.size() == 1);

        // longest prefix
        Assert.assertEquals("night", trie.longestPrefixOf("nightking"));
        Assert.assertEquals("zero", trie.longestPrefixOf("zerotr"));
        Assert.assertEquals("ze", trie.longestPrefixOf("zez"));
        Assert.assertEquals("zer", trie.longestPrefixOf("zerR"));
        Assert.assertEquals("z", trie.longestPrefixOf("z"));
        Assert.assertEquals("", trie.longestPrefixOf("11"));

        // strict prefix
        Assert.assertEquals("night", trie.strictLongestPrefixOf("nightking"));
        Assert.assertEquals("", trie.strictLongestPrefixOf("nighkking"));
        Assert.assertEquals("", trie.longestPrefixOf("11"));

        // regex match
        Assert.assertEquals(Arrays.asList("night"), trie.keysThatMatch("night"));
        Assert.assertEquals(Arrays.asList(), trie.keysThatMatch("XXX"));
        Set<String> expected = new HashSet<>(Arrays.asList("zero", "fero"));
        Assert.assertEquals(expected, iterableToSet(trie.keysThatMatch(".ero")));

        trie.put("abcdefgh", 1);
        trie.put("avctefyh", 1);
        expected = new HashSet<>(Arrays.asList("abcdefgh", "avctefyh"));
        Assert.assertEquals(expected, iterableToSet(trie.keysThatMatch("a.c.ef.h")));
    }

    @Test
    public void testDelete() {
        RWayTrie<Integer> trie = new RWayTrie<>();

        trie.put("hello", 1);
        trie.put("helsinky", 1);
        trie.put("hellopad", 1);
        trie.put("mazda", 2);
        trie.put("mazdicka", 2);

        trie.delete("helsinky");
        Assert.assertNull(trie.get("helsinky"));
        Assert.assertNull(trie.get("helsink"));
        Assert.assertNotNull(trie.get("hello"));
        Assert.assertNotNull(trie.get("hellopad"));

        trie.delete("mazda");
        Assert.assertNull(trie.get("mazda"));
        Assert.assertNotNull(trie.get("mazdicka"));
        Assert.assertNotNull(trie.get("hello"));
    }

    public <T> Set<T> iterableToSet(Iterable<T> iterator) {
        Set<T> set = new HashSet<>();
        iterator.forEach(s -> set.add(s));
        return set;
    }
}
