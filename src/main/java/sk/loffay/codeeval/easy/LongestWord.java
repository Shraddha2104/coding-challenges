package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class LongestWord {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            System.out.println(longestWord(line));
        }
    }

    public static String longestWord(String line) {

        int from = 0;
        int fromFixed = 0;
        int length = 0;
        for (int i = 0; i < line.length(); i++) {
            if (i == line.length() - 1) {
                i++;
            }

            if (i == line.length() || line.charAt(i) == ' ') {
                if (i - from > length) {
                    fromFixed = from;
                    length = i - from;
                }
                from = i + 1;
            }
        }

        return line.substring(fromFixed, fromFixed + length);
    }
}
