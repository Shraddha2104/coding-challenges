package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class StringRotation {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(",");

            if (isRotation(split[0], split[1])) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    public static boolean isRotation(String original, String rotated) {

        if (original.length() != rotated.length()) {
            return false;
        }

        for (int i = 0; i < rotated.length(); i++) {
            if (original.charAt(0) == rotated.charAt(i)) {

                int iOrig = 0;
                int iRotated = i;
                while (iOrig < original.length()) {
                    if (original.charAt(iOrig) != rotated.charAt(iRotated)) {
                        break;
                    }

                    iRotated++;
                    if (iRotated == rotated.length()) {
                        iRotated = 0;
                    }
                    iOrig++;
                }

                if (iOrig == original.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
