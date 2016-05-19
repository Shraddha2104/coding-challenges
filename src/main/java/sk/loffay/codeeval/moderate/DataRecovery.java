package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100%
 */
public class DataRecovery {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            String[] split = line.split(";");
            String[] words = split[0].trim().split(" ");
            String[] orderStr = split[1].trim().split(" ");
            int[] order = new int[orderStr.length];
            String[] original = new String[words.length];


            for (int i = 0; i < orderStr.length; i++) {
                order[i] = Integer.parseInt(orderStr[i]);
            }

            int i = 0;
            while (i < orderStr.length) {
                int index = order[i];
                original[index - 1] = words[i];
                i++;
            }

            for (int j = 0; j < words.length; j++) {
                if (original[j] == null) {
                    original[j] = words[i];
                    i++;
                }
            }

            // print
            StringBuilder stringBuilder = new StringBuilder();
            for (String word: original) {
                stringBuilder.append(word).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }
}
