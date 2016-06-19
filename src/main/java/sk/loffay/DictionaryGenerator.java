package sk.loffay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for generating dictionary entries
 * @author Pavol Loffay
 */
public class DictionaryGenerator {

    public static List<String> parseWords() throws IOException {

        ClassLoader classLoader = DictionaryGenerator.class.getClassLoader();
        File inputFile = new File(classLoader.getResource("textForDictionary").getFile());

        BufferedReader buffer = new BufferedReader(new FileReader(inputFile));
        String line;

        Map<String, Integer> wordsMap = new HashMap<>();

        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(" ");

            for (String word: split) {
                word = word.toLowerCase();
                word = removeCharacters(word);
                if (!word.matches("[a-zA-Z0-9]+")) {
                    continue;
                }

                Integer count = wordsMap.get(word);
                if (count == null) {
                    wordsMap.put(word, 1);
                } else {
                    wordsMap.put(word, ++count);
                }
            }
        }

        TreeMap<String, Integer> sortedWordsMap = new TreeMap<>(new ValueComparator(wordsMap));
        sortedWordsMap.putAll(wordsMap);

        return new ArrayList<>(sortedWordsMap.keySet());
    }

    private static String removeCharacters(String word) {
        word = word.trim();
        word = word.replaceAll(",", "");
        word = word.replaceAll(";", "");
        word = word.replaceAll("\\.", "");
        word = word.replaceAll("'", "");
        word = word.replaceAll("\"", "");
        word = word.replaceAll("-", "");

        return word;
    }

    private static class ValueComparator implements Comparator<String> {
        private Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}
