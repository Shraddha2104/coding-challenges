package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Pavol Loffay
 */
public class DetectingCycles {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            int[] sequence = lineToArray(line);
            int[] firstCycle = detectFirstCycle(sequence);

            StringBuilder stringBuilder =  new StringBuilder();
            for (int i = 0; i < firstCycle.length; i++) {
                stringBuilder.append(firstCycle[i]).append(" ");
            }

            System.out.println(stringBuilder.toString().trim());
        }
    }

    public static int[] detectFirstCycle(final int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int c = 0; c < i; c++) {
                if (arr[c] == arr[i]) {
                    if (verifyCycle(arr, c, i - c)) {
                        return Arrays.copyOfRange(arr, c, i);
                    }
                }
            }
        }

        return new int[0];
    }

    public static boolean verifyCycle(int[] arr, final int start, final int count) {
        if (start + 2*count-1 > arr.length - 1) {
            return false;
        }

        for (int i = start; i < start + count && i + count < arr.length; i++) {

            if (arr[i] != arr[i + count]) {
                return false;
            }
        }

        return true;
    }

    public static int[] lineToArray(String line) {

        String[] strArr = line.split(" ");
        int[] result = new int[strArr.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strArr[i]);

            if (result[i] < 0 || result[i] > 99) {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
