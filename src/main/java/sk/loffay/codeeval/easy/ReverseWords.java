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
public class ReverseWords {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(reverseWords(line.toCharArray()));
        }
    }

    public static String reverseWords(char[] str) {
        if (str.length == 0) {
            return String.valueOf(str);
        }

        //reverse
        for (int i = 0; i < str.length/2; i++) {
            swap(str, i, str.length - i - 1);
        }

        //reverse words
        boolean space = false;
        int from = 0;
        for (int i = 0; i <= str.length; i++) {
            if ((i== str.length || str[i] == ' ') && !space) {
                reverse(str, from, i - 1);
                space = true;
            } else if (str[i] != ' ' && space) {
                from = i;
                space = false;
            }
        }

        return String.valueOf(str);
    }

    public static void reverse(char[] str, int from, int to) {
        for (int i = from; i <= from + (to - from)/2; i++) {
            swap(str, i, to - (i - from));
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
