package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 48.754
 * mem: 9986048
 */
public class MeetCombSort {

    private static double DECREASE_FACTOR = 1.25;

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(" ");
            int[] arr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.parseInt(split[i].trim());
            }

            int combSort = combSort(arr);
            System.out.println(combSort);
        }
    }

    public static int combSort(int[] arr) {

        int iterations = 0;
        int gap = arr.length;

        while (true) {

            if (gap > 1) {
                gap = roundToSmaller(gap/DECREASE_FACTOR);
            }

            boolean swapped = false;
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i] > arr[i + gap]) {
                    swapped = true;
                    int swap = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = swap;
                }
            }

            if (!swapped && gap == 1) {
                return iterations;
            }

            iterations++;
        }
    }

    public static int roundToSmaller(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal.setScale(0, BigDecimal.ROUND_DOWN);
        return bigDecimal.intValue();
    }
}
