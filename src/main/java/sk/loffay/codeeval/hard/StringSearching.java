package sk.loffay.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import sk.loffay.Tags;

/**
 * '*' matches zero or more characters
 *
 * @author Pavol Loffay
 */
@Tags({"string"})
public class StringSearching {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");

            System.out.println(isSubstring(split[0].trim(), split[1].trim()));
        }
    }

    public static boolean isSubstring(String str, String pattern) {

        Regex regex = new Regex(pattern);
        return regex.match(str);
    }

    private static class Regex {
        private List<RegexSegment> segments = new ArrayList<>();

        public Regex(String regex) {
            constructSegments(regex);
        }

        private void constructSegments(String regex) {

            StringBuilder stringBuilder = new StringBuilder();
            boolean isEscapedWildcard = false;

            for (int i = 0; i < regex.length(); i++) {
                if (i + 1 < regex.length() && regex.charAt(i) == '\\' && regex.charAt(i+1) == '*') {
                    isEscapedWildcard = true;
                    continue;
                } else if (!isEscapedWildcard && regex.charAt(i) == '*') {
                    if (stringBuilder.length() > 0) {
                        segments.add(new RegexSegment(stringBuilder.toString(), false));
                        stringBuilder.setLength(0);
                    }
                    segments.add(new RegexSegment("*", true));
                } else {
                    stringBuilder.append(regex.charAt(i));
                }

                isEscapedWildcard = false;
            }

            if (stringBuilder.length() > 0) {
                segments.add(new RegexSegment(stringBuilder.toString(), false));
            }
        }

        public boolean match(String str) {
            matchSegments(str);
            return evaluateSegments();
        }

        private RegexSegment previousNonWildcard(int current) {

            while (--current >= 0) {
                if (!segments.get(current).isWildcard) {
                    return segments.get(current);
                }
            }

            return null;
        }

        private boolean evaluateSegments() {
            for (int i = 1; i < segments.size(); i++) {
                final RegexSegment current = segments.get(i);
                final RegexSegment previous = previousNonWildcard(i);
                if (current.isWildcard || previous == null) {
                    continue;
                }

                boolean previousIsWildcard = segments.get(i-1).isWildcard;
                Set<Integer> newPatternEndSet = new TreeSet<>(current.patternEnd);

                for (Integer end: current.patternEnd) {
                    if (!previousIsWildcard && !previous.patternEnd.contains(end-1)) {
                            newPatternEndSet.remove(end);
                    } else if (previousIsWildcard) {
                        boolean  previousContainsKMinusOne = false;
                        for (Integer previousEnd: previous.patternEnd) {
                            if (previousEnd < end-1) {
                                previousContainsKMinusOne = true;
                                break;
                            }
                        }
                        if (!previousContainsKMinusOne) {
                            newPatternEndSet.remove(end);
                        }
                    }
                }

                current.patternEnd = newPatternEndSet;
            }

            for (RegexSegment segment: segments) {
                if (!segment.isWildcard && segment.patternEnd.isEmpty()) {
                    return false;
                }
            }

            return true;
        }

        private void matchSegments(String str) {
            for (RegexSegment segment: segments) {
                if (segment.isWildcard) {
                    continue;
                }

                int i = 0;
                while (i < str.length()) {
                    if (str.charAt(i) == segment.pattern.charAt(0)) {
                        int j = 0;
                        for (; j < segment.pattern.length(); j++) {
                            if (i + j < str.length() && str.charAt(i + j) != segment.pattern.charAt(j)) {
                                break;
                            }
                        }

                        if (j == segment.pattern.length()) {
                            segment.patternEnd.add(i + j - 1);
                        }
                    }

                    i++;
                }
            }
        }
    }

    private static class RegexSegment {
        private final String pattern;
        private final boolean isWildcard;

        private Set<Integer> patternEnd = new TreeSet<>();


        public RegexSegment(String pattern, boolean isWildcard) {
            this.pattern = pattern;
            this.isWildcard = isWildcard;
        }
    }
}
