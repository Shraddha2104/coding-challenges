package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Pavol Loffay
 */
public class ReverseGroups {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();

            System.out.println(reverseGroups(line));
        }
    }

    public static String reverseGroups(String line) {
        String[] split = line.split(";");
        int reversionLength = Integer.parseInt(split[1].trim());
        String[] numbers = split[0].trim().split(",");

        if (reversionLength < numbers.length) {
            final int numberOfReversions = numbers.length/reversionLength;
            for (int i = 0; i < numberOfReversions; i++) {
                reverse(numbers, i*reversionLength, i*reversionLength + reversionLength -1);
            }
        }

        return Arrays.toString(numbers).replace("[", "").replace("]", "").replace(" ", "").trim();
    }

    public static void reverse(String[] str, int from, int to) {
        for (int i = from; i <= from + (to - from)/2; i++) {
            swap(str, i, to - (i - from));
        }
    }

    public static void swap(String[] str, int i, int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
