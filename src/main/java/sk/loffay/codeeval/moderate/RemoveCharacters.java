package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 51.305
 * mem: 8482816
 */
public class RemoveCharacters {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Params params = parseLine(line);

            String str = removeCharacters(params);

            System.out.println(str);
        }
    }

    private static String removeCharacters(Params params) {

        String str = params.str;

        for (char ch: params.remove.toCharArray()) {
            str = str.replaceAll(ch + "", "");
        }

        return str;
    }

    private static Params parseLine(String line) {
        String[] split = line.split(",");

        Params params = new Params(split[1].trim(), split[0].trim());

        return params;
    }

    private static class Params {
        String remove;
        String str;

        public Params(String remove, String str) {
            this.remove = remove;
            this.str = str;
        }
    }
}
