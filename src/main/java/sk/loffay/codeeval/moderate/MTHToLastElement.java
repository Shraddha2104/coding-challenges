package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class MTHToLastElement {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            if (line == null || line.isEmpty()) {
                continue;
            }

            Character ch = mthLastElement(line);

            if (ch != null) {
                System.out.println(ch);
            }
        }
    }

    public static Character mthLastElement(String line) {
        String[] split = line.split(" ");

        Integer index = Integer.parseInt(split[split.length - 1].trim());

        if (index > split.length -1) {
            return null;
        }

        char character = split[split.length - index -1].charAt(0);

        return character;
    }
}
