package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class SumOfDigits {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int sumOfDigits = sumOfDigitsFromInt(line);
            System.out.println(sumOfDigits);
        }
    }

    public static int sumOfDigitsFromInt(String line) {
        int lineInt = Integer.parseInt(line);

        int sumOfDigits = 0;
        while (lineInt > 0) {
            sumOfDigits += lineInt%10;
            lineInt /= 10;
        }

        return sumOfDigits;
    }

    public static int sumOfDigitsFromString(String line) {

        int sumOfDigits = 0;

        for (int i = line.length() -1 ; i >= 0; i--) {
            sumOfDigits += Integer.parseInt(""+line.charAt(i));
        }

        return sumOfDigits;
    }
}
