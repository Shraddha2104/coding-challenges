package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class NumberOperations {
    private static final List<List<Character>> allOperators = operators(new LinkedList<>());

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] numStr = line.split(" ");
            Integer[] numbers = new Integer[numStr.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numStr[i]);
            }

            boolean possible = isPossibleToGet42(numbers);
            System.out.println(possible ? "YES" : "NO");
        }
    }


    private static boolean isPossibleToGet42(Integer[] numbers) {

        for (List<Integer> integers: numberPermutations(Arrays.asList(numbers))) {

            for (List<Character> operators : allOperators) {
                int result = operation(integers.get(0), integers.get(1), operators.get(0));
                result = operation(result, integers.get(2), operators.get(1));
                result = operation(result, integers.get(3), operators.get(2));
                result = operation(result, integers.get(4), operators.get(3));

                if (result == 42) {
                    return true;
                }
            }
        }

        return false;
    }

    public static List<List<Integer>> numberPermutations(List<Integer> numbers) {

        if (numbers.size() == 2) {
            LinkedList<List<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>(Arrays.asList(numbers.get(0), numbers.get(1))));
            result.add(new LinkedList<>(Arrays.asList(numbers.get(1), numbers.get(0))));
            return result;
        }

        LinkedList<List<Integer>> result = new LinkedList<>();

        for (Integer nun: numbers) {
            List<Integer> subset = new LinkedList<>(numbers);
            subset.remove(nun);
            List<List<Integer>> permu = numberPermutations(subset);

            for (List<Integer> arr: permu) {
                arr.add(nun);
                result.add(arr);
            }
        }

        return result;
    }

    private static int operation(int a, int b, char op) {
        switch (op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }

        throw new IllegalArgumentException("Illegal operation " + op);
    }

    public static List<List<Character>> operators(List<Character> operators) {

        if (operators.size() == 4) {
            List<List<Character>> result = new LinkedList<>();
            result.add(operators);
            return result;
        }

        List<List<Character>> result = new LinkedList<>();

        LinkedList<Character> operPlus = new LinkedList<>(operators);
        operPlus.add('+');
        result.addAll(operators(operPlus));

        LinkedList<Character> operMinus = new LinkedList<>(operators);
        operMinus.add('-');
        result.addAll(operators(operMinus));

        LinkedList<Character> operMul = new LinkedList<>(operators);
        operMul.add('*');
        result.addAll(operators(operMul));

        return result;
    }
}
