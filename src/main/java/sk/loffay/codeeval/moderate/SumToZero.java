package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
        return sumToZero(Arrays.asList(numbers));
    }

    public static int sumToZero(List<Integer> numbers) {

        int sumToZeroCount = 0;

        for (List<Integer> combination: combinations(numbers, 4)) {

            int sum = 0;
            for (int number: combination) {
                sum += number;
            }

            if (sum == 0) {
                sumToZeroCount++;
            }
        }

        return sumToZeroCount;
    }


    public static <T> List<List<T>> combinations(List<T> elements, int size) {
        elements = new LinkedList<>(elements);
        List<List<T>> result = new ArrayList<>();

        if (size == 1) {
            for (int i = 0; i < elements.size(); i++) {
                List<T> partialResult = new ArrayList<>();
                partialResult.add(elements.get(i));
                result.add(partialResult);
            }
            return result;
        }

        Iterator<T> iterator = elements.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            iterator.remove();
            List<T> nextElements = new ArrayList<>(elements);

            List<List<T>> partialResult = combinations(nextElements, size - 1);
            for (List<T> partial : partialResult) {
                partial.add(element);
            }

            result.addAll(partialResult);
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
