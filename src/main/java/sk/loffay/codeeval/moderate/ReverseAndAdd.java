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
public class ReverseAndAdd {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            // Process line of input Here

            int number = Integer.parseInt(line);
            int iterations = 0;
            while (!isPalindrome(number)) {
                number += reverseNum(number);
                iterations++;

                if (iterations > 1000) {
                    break;
                }
            }

            System.out.println(iterations + " " + number);
        }
    }

    public static int reverseNum(int num) {
        int reversed  = 0;
        while (num > 0) {
            reversed = reversed*10;
            reversed = reversed + num%10;

            num = num/10;
        }

        return reversed;
    }

    public static boolean isPalindrome(int num) {
        String strNum = Integer.toString(num);
        int length = strNum.length();

        for (int i = 0; i < length/2; i++) {
            if (strNum.charAt(i) != strNum.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
