package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class TrailingString {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            if (line.isEmpty()) {
                continue;
            }

            String[] split = line.split(",");
            char[] sentence = split[0].trim().toCharArray();
            char[] word = split[1].trim().toCharArray();

            int i = word.length - 1;
            int j = sentence.length - 1;
            while (i >= 0 && j >= 0) {
                if (word[i] != sentence[j]) {
                    break;
                }

                i--;
                j--;
            }

            if (i < 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
