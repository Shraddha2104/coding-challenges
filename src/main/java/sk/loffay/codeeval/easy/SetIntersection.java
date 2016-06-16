package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class SetIntersection {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            List<Set<Integer>> sets = parsetInput(line);
            Set<Integer> intersection = intersection(sets);

            System.out.println(setToString(intersection));
        }
    }

    public static Set<Integer> intersection(List<Set<Integer>> setList) {
        if (setList.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Integer> interSectionResult = new TreeSet<>();
        Set<Integer> firstSet = setList.get(0);

        for (int i = 1; i < setList.size(); i++) {
            for (Integer integer: setList.get(i)) {
                if (firstSet.contains(integer)) {
                    interSectionResult.add(integer);
                } else {
                    firstSet.remove(integer);
                }
            }
        }

        return interSectionResult;
    }

    public static List<Set<Integer>> parsetInput(String line) {
        String[] setSplit = line.split(";");

        List<Set<Integer>> setList = new ArrayList<>();

        for (String set: setSplit) {
            Set<Integer> integers = toIntSet(set.trim().split(","));
            setList.add(integers);
        }

        return setList;
    }

    private static Set<Integer> toIntSet(String[] numbers) {
        Set<Integer> numbersSet = new HashSet<>();

        for (String numStr: numbers) {
            numbersSet.add(Integer.parseInt(numStr));
        }

        return numbersSet;
    }

    public static String setToString(Set<Integer> set) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer: set) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }

            stringBuilder.append(integer);
        }

        return stringBuilder.toString();
    }
}
