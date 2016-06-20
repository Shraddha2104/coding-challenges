package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Pavol Loffay
 *
 * TODO not done
 */
public class SumToZero {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            System.out.println(sumToZero(line));
        }
    }

    public static int sumToZero(String line) {
        Integer[] numbers = parseLine(line);
        return sumToZero(new LinkedList<>(Arrays.asList(numbers)), 0, new HashSet<>(), new ArrayList<>());
    }

    public static int sumToZero(LinkedList<Integer> numbers, int sum,
                                Set<String> results,
                                List<Integer> summed) {
        if (summed.size() >= 4) {
            if (sum == 0) {
                Collections.sort(summed);
                String key = summed.toString();
                boolean added = results.add(key);
                if (added) {
                    return 1;
                } else {
                    for (Integer integer: summed) {
                        if (numbers.contains(integer)) {
                            return 1;
                        }
                    }
                }
            }
            return 0;
        }

        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                LinkedList<Integer> nextArr = new LinkedList<>(numbers);
                nextArr.remove(i);
                nextArr.remove(j-1);

                List<Integer> summedNext = new ArrayList<>(summed);
                summedNext.add(numbers.get(i));
                summedNext.add(numbers.get(j));

                result += sumToZero(nextArr, sum + numbers.get(i) + numbers.get(j), results, summedNext);
            }
        }

        return result;
    }

    public static Integer[] parseLine(String line) {
        String[] split = line.split(",");
        Integer[] numbers = new Integer[split.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(split[i].trim());
        }

        return numbers;
    }
}
