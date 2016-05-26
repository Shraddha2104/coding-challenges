package sk.loffay.netsute;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Pavol Loffay
 */
public class FindAnagrams {

    private static FindAnagrams instance;

    private Map<String, Set<String>> anagramsMap = new TreeMap<>();

    public static FindAnagrams getInstance() {
        return instance = (instance == null ? new FindAnagrams() : instance);
    }

    private FindAnagrams() {

        for (String word: Dictionary.WORDS) {
            String key = keyForAnagramMap(word);
            Set<String> anagrams = anagramsMap.get(key);

            if (anagrams == null) {
                anagrams = new HashSet<>();
                anagramsMap.put(key, anagrams);
            }

            anagrams.add(word);
        }
    }

    /**
     * Method should return all anagrams of the input word in log(N) time
     * @param word - input word
     * @return unmodifiable set of anagrams, or empty if there are not any
     */
    public Set<String> findAnagrams(String word) {

        String key = keyForAnagramMap(word);
        Set<String> anagrams = anagramsMap.get(key);

        return Collections.unmodifiableSet(anagrams == null ? Collections.emptySet() : anagrams);
    }

    private static String keyForAnagramMap(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}
