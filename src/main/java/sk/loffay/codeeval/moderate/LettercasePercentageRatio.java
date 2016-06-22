package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class LettercasePercentageRatio {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            double lowerCasePer = lowerCasePercentage(line);

            System.out.format("lowercase: %.2f uppercase: %.2f\n", lowerCasePer, 100 - lowerCasePer);
        }
    }

    public static double lowerCasePercentage(String str) {

        int lowerCaseCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                lowerCaseCount++;
            }
        }

        return ((double) lowerCaseCount*100)/str.length();
    }
}
