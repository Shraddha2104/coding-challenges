package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class MultiplyLists {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int[][] twoArrays = parseLine(line);
            int[] result = multiplyArrays(twoArrays);

            System.out.println(arrToString(result));
        }
    }

    public static String arrToString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (sb.length() != 0) {
                sb.append(" ");
            }

            sb.append(result[i]);
        }

        return sb.toString();
    }

    public static int[] multiplyArrays(int[][] arr) {
        if (arr[0].length != arr[1].length) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[arr[0].length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[0][i] * arr[1][i];
        }

        return result;
    }

    public static int[][] parseLine(String line) {

        String[] split = line.split("\\|");
        String[] arr1Str = split[0].trim().split(" ");
        String[] arr2Str = split[1].trim().split(" ");

        int[] arr1 = strToInt(arr1Str);
        int[] arr2 = strToInt(arr2Str);

        return new int[][]{arr1, arr2};
    }

    public static int[] strToInt(String[] str) {
        int[] intArr = new int[str.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(str[i]);
        }

        return intArr;
    }
}
