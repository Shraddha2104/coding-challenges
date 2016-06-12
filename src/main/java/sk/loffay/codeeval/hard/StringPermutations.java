package sk.loffay.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class StringPermutations {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(permutations(line).toString().replace(" ", "").replace("[", "").replace("]", ""));
        }
    }

    public static Set<String> permutations(String word) {

        if (word.length() == 1) {
            return new TreeSet<>(Arrays.asList(word));
        }

        Set<String> permutations = new TreeSet<>();

        for (int i = 0; i < word.length(); i++) {
            String str = new StringBuilder(word).deleteCharAt(i).toString();
            Set<String> partialPermutations = permutations(str);
            for (String partial: partialPermutations) {
                permutations.add(word.charAt(i) + partial);
            }
        }

        return permutations;
    }
}
