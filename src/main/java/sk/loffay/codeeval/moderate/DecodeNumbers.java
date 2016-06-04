package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class DecodeNumbers {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int combinations = decode(line);
            System.out.println(combinations);
        }
    }

    public static int decode(String num) {

        if (num.length() == 0) {
            return 1;
        }

        int singleDecode = decode(num.substring(1));
        int doubleDecode = 0;

        if (num.length() >= 2 && isInRange(Integer.parseInt(num.substring(0, 2)))) {
            doubleDecode = decode(num.substring(2));
        }

        return singleDecode + doubleDecode;
    }

    private static boolean isInRange(int num) {
        return num >= 1 && num <= 26;
    }
}
