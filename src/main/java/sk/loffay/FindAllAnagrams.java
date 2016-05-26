package sk.loffay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Pavol Loffay
 */
public class FindAllAnagrams {

    public static List<String> allAnagrams(String word) {

        List<Character> hashSet = new ArrayList<>(word.length());
        for (Character ch: word.toCharArray()) {
            hashSet.add(ch);
        }

        return anagram(hashSet);
    }

    public static List<String> anagram(List<Character> chars) {

        if (chars.size() == 2) {
            HashSet<String> strings =
                    new HashSet<>(Arrays.asList("" + chars.get(0) + chars.get(1), "" + chars.get(1) + chars.get(0)));
            return new ArrayList<>(strings);
        }

        Set<String> result = new HashSet<>(chars.size()*chars.size());

        for (Character ch: chars) {
            List<Character> subSet = new ArrayList<>(chars);
            subSet.remove(ch);
            List<String> anagrams = anagram(subSet);

            for (String anagram: anagrams) {
                String newAnagram = ch + anagram;
                result.add(newAnagram);
            }
        }
        return new ArrayList<>(result);
    }
}
