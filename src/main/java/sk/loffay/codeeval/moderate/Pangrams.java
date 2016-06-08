package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class Pangrams {
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            System.out.println(panagrams(line));
        }
    }

    public static String panagrams(String line) {
        line = line.toLowerCase();

        Set<Character> enAlphabet = toSet(ALPHABET);
        for (Character ch: line.toCharArray()) {
            enAlphabet.remove(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (enAlphabet.isEmpty()) {
            stringBuilder.append("NULL");
        } else {
            for (Character ch: enAlphabet) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    private static Set<Character> toSet(char[] arr) {
        Set<Character> result = new TreeSet<>();
        for (char ch: arr) {
            result.add(ch);
        }

        return result;
    }
}
