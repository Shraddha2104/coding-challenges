package sk.loffay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class FindAllAnagramsTest {

    @Test
    public void test() {
        String word = "1233";
        List<String> anagrams = FindAllAnagrams.allAnagrams(word);
        System.out.println(anagrams);
        Assert.assertFalse(containsDuplicates(anagrams));

        word = "123";
        anagrams = FindAllAnagrams.allAnagrams(word);
        System.out.println(anagrams);
        Assert.assertEquals((new Factorial.RecursiveFactorial()).factorial(word.length()), anagrams.size());
        Assert.assertFalse(containsDuplicates(anagrams));

        word = "ahoj";
        anagrams = FindAllAnagrams.allAnagrams(word);
        Assert.assertEquals((new Factorial.RecursiveFactorial()).factorial(word.length()), anagrams.size());
        Assert.assertFalse(containsDuplicates(anagrams));
        System.out.println(anagrams);

        word = "abvsdrf";
        anagrams = FindAllAnagrams.allAnagrams(word);
        Assert.assertEquals((new Factorial.RecursiveFactorial()).factorial(word.length()), anagrams.size());
        Assert.assertFalse(containsDuplicates(anagrams));
        System.out.println(anagrams);
    }

    private boolean containsDuplicates(List<String> words) {

        Set<String> set = new HashSet<>();
        for (String word: words) {
            if (!set.contains(word)) {
                set.add(word);
            } else {
                return true;
            }
        }

        return false;
    }
}
