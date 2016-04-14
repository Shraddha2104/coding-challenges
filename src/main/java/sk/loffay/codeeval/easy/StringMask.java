package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 27.999
 */
public class StringMask {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] params = line.split(" ");
            String str = params[0];
            String mask = params[1];

            System.out.print(stringMask(str, mask));
        }
    }

    public static String stringMask(String str, String mask) {
        if (str.length() < 1 || str.length() > 20 ||
                str.length() != mask.length()) {
            throw new IllegalArgumentException();
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            char m = mask.charAt(i);

            if (m == '1') {
                letter = Character.toUpperCase(letter);
            }

            stringBuilder.append(letter);
        }

        return stringBuilder.append("\n").toString();
    }
}
