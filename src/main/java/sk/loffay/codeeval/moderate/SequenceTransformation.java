package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pavol Loffay
 * TODO NOT DONE
 */
public class SequenceTransformation {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(" ");
            String code = split[0].trim();
            String letters = split[1].trim();

            System.out.println(canBeTransformedRegex(code, letters) ? "Yes" : "No");
        }
    }

    /**
     * 0 - A, AA, AAA*
     * 1 - A, AA, AAA*, B, BB, BBB*
     */
    public static boolean canBeTransformed(String code, String letters) {

        if (code.length() == 0 && letters.length() == 0) {
            return true;
        }

        for (int remove = maxRemove(code, letters); remove > 0; remove--) {
            boolean canBeTransformed = canBeTransformed(code.substring(1), letters.substring(remove));
            if (canBeTransformed) {
                return true;
            }
        }

        return false;
    }

    /**
     * Always remove first from code
     */
    public static boolean canRemove(String code, String letters, int letterToRemove) {
        if (code.isEmpty() || letters.length() < letterToRemove) {
            return false;
        }
        if (code.length() - 1 > letters.length() - letterToRemove) {
            return false;
        }

        char firstToRemove = letters.charAt(0);
        for (int i = 0; i < letterToRemove; i++) {
            if (code.charAt(0) == '0' && letters.charAt(i) == 'B') {
                return false;
            }

            if (code.charAt(0) == '1' && letters.charAt(i) != firstToRemove) {
                return false;
            }
        }

        return true;
    }

    public static int maxRemove(String code, String letters) {

        for (int i = letters.length() - (code.length()-1); i > 0; i--) {
            if (canRemove(code, letters, i)) {
                return i;
            }
        }

        return 0;
    }

    public static boolean canBeTransformedRegex(String code, String letters) {
        String regex = buildRegex(code);
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(letters);
        return matcher.matches();
    }

    private static String buildRegex(String code) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < code.length(); i++) {
            if (code.charAt(i) == '0') {
                stringBuilder.append("A+");
            } else {
                stringBuilder.append("(A+|B+)");
            }
        }

        return stringBuilder.toString();
    }
}
