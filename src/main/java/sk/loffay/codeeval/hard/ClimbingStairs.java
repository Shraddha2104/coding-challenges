package sk.loffay.codeeval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import sk.loffay.Tags;

/**
 * @author Pavol Loffay
 */
public class ClimbingStairs {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Long stairs = Long.parseLong(line);

            System.out.println(nonRecursivePermutations(stairs));
        }
    }

    /**
     * nice way how to compute permutations without recursion
     */
    @Tags({"permutations"})
    public static long nonRecursivePermutations(long number) {

        long b = 1l;
        long c = 1l;
        for (int i = 1; i < number; i++) {
            Long oldB = b;
            b = c;
            c = oldB + c;
        }

        return c;
    }

    public static long recursivePermutations(long number) {
        Map<Long, Long> resultsCache = new HashMap<>();
        resultsCache.put(1l, 1l);
        resultsCache.put(2l, 2l);
        return recursivePermutations(number, resultsCache);
    }

    @Tags({"permutations"})
    private static Long recursivePermutations(Long number, Map<Long, Long> results) {

        if (results.containsKey(number)) {
            return results.get(number);
        }

        Long result = recursivePermutations(number - 1, results) + recursivePermutations(number - 2, results);
        results.put(number, result);

        return result;
    }
}
