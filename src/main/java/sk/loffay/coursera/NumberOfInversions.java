package sk.loffay.coursera;

import java.util.ArrayList;
import java.util.List;

/**
 * Algorithms: Design and Analysis, Part 1::Programming Question-1
 *
 * @author Pavol Loffay
 */
public class NumberOfInversions {

    public static long numberOfInversions(List<Integer> numbers) {
        Tuple tuple = numberOfInversionsTuple(numbers);
        return tuple.inversions;
    }

    public static Tuple numberOfInversionsTuple(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return new Tuple(numbers, 0);
        }

        if (numbers.size() == 1) {
            return new Tuple(numbers, 0);
        }

        int middle = numbers.size() >> 1;
        Tuple left = numberOfInversionsTuple(numbers.subList(0, middle));
        Tuple right = numberOfInversionsTuple(numbers.subList(middle, numbers.size()));
        Tuple split = countSplitInversions(left.list, right.list);

//        return new Tuple(split.list, split.inversions + left.inversions + right.inversions);
        return new Tuple(split.list, split.inversions + left.inversions + right.inversions);
    }

    private static Tuple countSplitInversions(List<Integer> left, List<Integer> right) {

        List<Integer> result = new ArrayList<>();
        long inversions = 0;
        int indexRight = 0;
        for (int indexLeft = 0; indexLeft < left.size();) {
            if (indexRight < right.size() && left.get(indexLeft) > right.get(indexRight)) {
                inversions += left.size() - indexLeft;
                result.add(right.get(indexRight));
                indexRight++;
            } else {
                result.add(left.get(indexLeft));
                indexLeft++;
            }
        }

        for (; indexRight < right.size(); indexRight++) {
            result.add(right.get(indexRight));
        }

        return new Tuple(result, inversions);
    }

    private static class Tuple {
        private List<Integer> list;
        private long inversions;

        public Tuple(List<Integer> list, long inversions) {
            this.list = list;
            this.inversions = inversions;
        }
    }
}
