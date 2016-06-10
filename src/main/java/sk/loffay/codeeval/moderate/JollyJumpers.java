package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Pavol Loffay
 */
public class JollyJumpers {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            if (line.length() == 0) {
                continue;
            }

            String[] strNum = line.split(" ");
            int[] numbers = new int[strNum.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(strNum[i]);
            }

            System.out.println(jollyJumpers(numbers) ? "Jolly" : "Not jolly");
        }
    }

    public static boolean jollyJumpers(int[] numbers) {
        if (numbers.length == 1) {
            return true;
        }

        Set<Integer> seen = new HashSet<>();

        for (int i = 1; i < numbers.length; i++) {
            Integer diff = Math.abs(numbers[i] - numbers[i-1]);
            if (diff < 1 || diff > numbers.length-1 || seen.contains(diff)) {
                return false;
            }
            seen.add(diff);
        }

        return true;
    }
}
