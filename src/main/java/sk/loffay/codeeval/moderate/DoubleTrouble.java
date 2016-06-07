package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class DoubleTrouble {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();
            System.out.println(combinations(line));
        }
    }

    public static int combinations(String line) {
        int symmetricStars = 0;
        int stars = 0;
        for (int i = 0; i < line.length()/2; i++) {
            if (line.charAt(i) != '*' && line.charAt(line.length()/2 + i) != '*' &&
                    line.charAt(i) != line.charAt(line.length()/2 + i)) {

                return 0;
            }

            if (line.charAt(i) == '*' && line.charAt(line.length()/2 + i) == '*') {
                symmetricStars++;
            }

            if (line.charAt(i) == '*' || line.charAt(line.length()/2 + i) == '*') {
                stars++;
            }
        }

        return symmetricStars == 0 && stars > 0 ? 1 : (int)Math.pow(2, symmetricStars);
    }
}
