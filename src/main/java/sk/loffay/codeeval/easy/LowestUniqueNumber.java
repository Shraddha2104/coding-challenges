package sk.loffay.codeeval.easy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 */
public class LowestUniqueNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        while((line = bufferedReader.readLine()) != null) {
            line = line.trim();

            int[] indices = new int[9];

            int index = 1;
            for (String strNum: line.split(" ")) {
                int num = Integer.parseInt(strNum) - 1;

                if (indices[num] != 0) {
                    indices[num] = -1;
                } else {
                    indices[num] = index;
                }

                index++;
            }

            int found = 0;
            for (int i = 0; i < indices.length; i++) {
                if (indices[i] != -1 && indices[i] != 0) {
                    found = indices[i];
                    break;
                }
            }

            System.out.println(found);
        }
    }
}
