package sk.loffay.codility;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class BinaryCountOfOnesAfterSummationTest extends TestCase {

    @Test
    public void testSolution() throws Exception {

        BinaryCountOfOnesAfterSummation binaryCountOfOnesAfterSummation = new BinaryCountOfOnesAfterSummation();

        int result = binaryCountOfOnesAfterSummation.solution(3, 7);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binaryCountOfOnesAfterSummation.solution(2, 9);
        System.out.println(result);
        Assert.assertEquals(2, result);

        result = binaryCountOfOnesAfterSummation.solution(152, 14);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binaryCountOfOnesAfterSummation.solution(7731569, 7);
        System.out.println(result);
        Assert.assertEquals(14, result);

        result = binaryCountOfOnesAfterSummation.solution(1001687, 12);
        System.out.println(result);
        Assert.assertEquals(12, result);

        result = binaryCountOfOnesAfterSummation.solution(10, 10);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binaryCountOfOnesAfterSummation.solution(10001542, 12000145);
        System.out.println(result);
        Assert.assertEquals(24, result);

        result = binaryCountOfOnesAfterSummation.solution(100000000, 100000000);
        System.out.println(result);
        Assert.assertEquals(20, result);
    }

    @Test
    public void testCornerCases() {
        BinaryCountOfOnesAfterSummation binaryCountOfOnesAfterSummation = new BinaryCountOfOnesAfterSummation();

        int result = binaryCountOfOnesAfterSummation.solution(0, 0);
        System.out.println(result);
        Assert.assertEquals(0, result);

        result = binaryCountOfOnesAfterSummation.solution(0, 1);
        System.out.println(result);
        Assert.assertEquals(0, result);

        result = binaryCountOfOnesAfterSummation.solution(1, 0);
        System.out.println(result);
        Assert.assertEquals(0, result);
    }
}
