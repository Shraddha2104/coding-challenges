package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 */
public class NumberPairs {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(";");
            String[] strNumbers = split[0].trim().split(",");

            int sum = Integer.parseInt(split[1].trim());
            Set<Integer> numbersSet = new HashSet<>(strNumbers.length);
            for (int i = 0; i < strNumbers.length; i++) {
                numbersSet.add(Integer.parseInt(strNumbers[i].trim()));
            }

            Set<String> resultSet = new TreeSet<>((t1, t2) -> {
                int num1 = Integer.parseInt(t1.split(",")[0]);
                int num2 = Integer.parseInt(t2.split(",")[0]);
                return num1-num2;
            });
            for (Integer num: numbersSet) {
                if (num <= sum) {
                    final Integer complement = sum - num;
                    if (!complement.equals(num) && numbersSet.contains(complement)) {
                        resultSet.add(complement < num ? complement+","+num : num+","+complement);
                    }
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (String result: resultSet) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(";");
                }
                stringBuilder.append(result);
            }

            System.out.println(resultSet.isEmpty() ? "NULL" : stringBuilder);
        }
    }
}
