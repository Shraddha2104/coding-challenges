package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 63.059
 */
public class LongestLines {

    public static void main (String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        int lineNumber = 0;
        // TreeMap<Integer, String> space complexity would be...
        String[] longestLines = null;
        int indexOfShortest = 0;

        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            if (lineNumber++ == 0) {
                int nLongestLinesParam = Integer.parseInt(line);
                longestLines = new String[nLongestLinesParam];
                continue;
            }

            if (longestLines[indexOfShortest] == null || longestLines[indexOfShortest].length() < line.length()) {
                longestLines[indexOfShortest] = line;

                indexOfShortest = indexOfShortest(longestLines);
            }
        }

        Arrays.sort(longestLines, new Comparator<String>() {
            public int compare(String s, String t1) {
                return t1.length() - s.length();
            }
        });

        for (String str: longestLines) {
            if (str != null) {
                System.out.println(str);
            }
        }
    }

    public static int indexOfShortest(String[] arr) {
        int shortest = Integer.MAX_VALUE;
        int indexOfShortest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }

            if (arr[i].length() < shortest) {
                shortest = arr[i].length();
                indexOfShortest = i;
            }
        }

        return indexOfShortest;
    }
}
