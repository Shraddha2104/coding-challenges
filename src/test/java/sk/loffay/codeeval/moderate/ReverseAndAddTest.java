package sk.loffay.codeeval.moderate;

import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ReverseAndAddTest {

    @Test
    public void test() {
        System.out.println(ReverseAndAdd.reverseNum(195));

        int number = 195;
        while (!ReverseAndAdd.isPalindrome(number)) {
            number += ReverseAndAdd.reverseNum(number);
        }

        System.out.println(ReverseAndAdd.isPalindrome(353));
    }
}
