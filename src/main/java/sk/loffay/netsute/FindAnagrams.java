package sk.loffay.netsute;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Pavol Loffay
 */
public class FindAnagrams {

    private static FindAnagrams instance;

    private Map<String, Set<String>> anagramsMap = new TreeMap<>();

    private FindAnagrams() {

        for (String word: Dictionary.WORDS) {

        }
    }

    public static FindAnagrams getInstance() {
        return instance = (instance == null ? new FindAnagrams(): instance);
    }

    public Set<String> findWords(String word) {
        return Collections.emptySet();
    }

}
