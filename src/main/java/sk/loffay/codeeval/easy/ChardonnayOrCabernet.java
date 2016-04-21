package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class ChardonnayOrCabernet {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Params params = parseLine(line);
            List<String> matchedWines = matchedWines(params);

            StringBuilder stringBuilder = new StringBuilder();
            for (String wine: matchedWines) {
                stringBuilder.append(wine).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }

    public static List<String> matchedWines(Params params) {

        List<String> result = new ArrayList<>();

        for (String wine: params.wines) {
            String wineToModify = wine.toLowerCase();

            boolean containsAllLetters = true;
            for (char chOfLetters: params.letters.toCharArray()) {

                if (wineToModify.indexOf(chOfLetters) >= 0) {
                    wineToModify = wineToModify.replaceFirst(""+chOfLetters, "1");
                } else {
                    containsAllLetters = false;
                    break;
                }
            }
            if (containsAllLetters) {
                result.add(wine);
            }
        }

        if (result.isEmpty()) {
            result.add("False");
        }
        return result;
    }

    private static Params parseLine(String line) {

        String[] split = line.split("\\|");
        String letters = split[1].trim().toLowerCase();
        String[] wines = split[0].trim().split(" ");

        return new Params(letters, wines);
    }

    public static class Params {
        String letters;
        String[] wines;

        public Params(String letters, String[] wines) {
            this.letters = letters;
            this.wines = wines;
        }
    }
}
