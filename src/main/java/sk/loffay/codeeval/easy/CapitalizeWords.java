package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class CapitalizeWords {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(capitalizeWords(line));
        }
    }

    public static String capitalizeWords(String text) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if ((i > 0 && ch != ' ' && text.charAt(i - 1) == ' ') || stringBuilder.length() == 0) {
                ch = Character.toUpperCase(ch);
            }

            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }
}
