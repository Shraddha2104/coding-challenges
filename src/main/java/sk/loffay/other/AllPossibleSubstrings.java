package sk.loffay.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class AllPossibleSubstrings {

    public static List<String> allSubstrings(String str) {


        List<String> result = new ArrayList<>();

        for (int length = 1; length <= str.length(); length++) {
            for (int j = 0; j + length <= str.length(); j++) {
                String substring = str.substring(j, j + length);

                result.add(substring);
            }
        }

        return result;
    }
}
