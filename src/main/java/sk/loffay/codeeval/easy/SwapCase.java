package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import sk.loffay.Tags;

/**
 * @author Pavol Loffay
 */
@Tags("string")
public class SwapCase {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(line.toCharArray());
        }
    }

    public static String swapCase(char[] str) {

        for (int i = 0; i < str.length; i++) {
            if ((int)str[i] >= 65 && (int)str[i] <= 90) {
                str[i] = (char)(str[i] + 32);
            } else if ((int)str[i] >= 97 && (int)str[i] <= 122) {
                str[i] = (char)(str[i] - 32);
            }
        }

        return String.valueOf(str);
    }
}
