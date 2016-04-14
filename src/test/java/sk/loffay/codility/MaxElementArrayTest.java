package sk.loffay.codility;

import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class MaxElementArrayTest {

    @Test
    public void testSolution() throws Exception {

        MaxElementArray maxElementArray = new MaxElementArray();

        int[] a = {1 , 3, -3};
        int result = maxElementArray.solution(a);

        System.out.println(result);
    }
}
