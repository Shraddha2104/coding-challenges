package sk.loffay.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class RepeatedSubstring {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(longestRepeatedSubstring(line));
        }
    }

    public static String longestRepeatedSubstring(String str) {

        TreeSet<Substring> result = new TreeSet<>();
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int second = i + 1; second < str.length();) {
                final int iSecondFixed = second;
                if (str.charAt(i) == str.charAt(second)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int iContinue = i;
                    while (second < str.length() &&
                            iContinue < iSecondFixed &&
                            str.charAt(iContinue) == str.charAt(second)) {

                        stringBuilder.append(str.charAt(second));
                        iContinue++;
                        second++;
                    }
                    if (stringBuilder.length() > 0 && !isOnlySpace(stringBuilder.toString())) {
                        result.add(new Substring(counter, stringBuilder.toString()));
                        counter++;
                    }
                }
                second = iSecondFixed + 1;
            }
        }

        return result.isEmpty() ? "NONE" : result.first().substring;
    }

    private static class Substring implements Comparable<Substring> {
        final int position;
        final String substring;

        public Substring(int position, String substring) {
            this.position = position;
            this.substring = substring;
        }

        @Override
        public int compareTo(Substring s1) {

            if (this.substring.length() == s1.substring.length()) {
                return this.position - s1.position;
            }

            return s1.substring.length() - this.substring.length();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Substring)) return false;

            Substring substring1 = (Substring) o;

            if (position != substring1.position) return false;
            return substring.equals(substring1.substring);
        }

        @Override
        public int hashCode() {
            int result = position;
            result = 31 * result + (substring != null ? substring.hashCode() : 0);
            return result;
        }
    }

    public static boolean isOnlySpace(String str) {
        return str.matches("\\s+");
    }
}
