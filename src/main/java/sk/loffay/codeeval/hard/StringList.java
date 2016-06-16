package sk.loffay.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class StringList {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");

            int length = Integer.parseInt(split[0]);
            String letters = split[1];
            Set<Character> lettersSet = stringToSet(letters);

            Set<String> allWords = stringList(lettersSet, length);
            System.out.println(toStringForCodeeval(allWords));
        }
    }

    public static Set<String> stringList(Set<Character> letters, int length) {

        TreeSet<String> result = new TreeSet<>();

        if (length == 1) {
            for (char ch: letters)  {
                result.add(Character.toString(ch));
            }
            return result;
        }

        for (char ch: letters) {
            Set<String> newWords = stringList(letters, length - 1);

            for (String newWord: newWords) {
                result.add(ch + newWord);
            }
        }

        return result;
    }

    public static Set<Character> stringToSet(String str) {
        Set<Character> lettersSet = new HashSet<>();
        for (Character ch: str.toCharArray()) {
            lettersSet.add(ch);
        }

        return lettersSet;
    }

    public static String toStringForCodeeval(Set<String> words) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word: words) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(word);
        }

        return stringBuilder.toString();
    }
}
