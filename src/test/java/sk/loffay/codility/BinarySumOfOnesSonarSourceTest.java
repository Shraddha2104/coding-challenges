package sk.loffay.codility;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class BinarySumOfOnesSonarSourceTest extends TestCase {

    @Test
    public void testSolution() throws Exception {

        BinarySumOfOnesSonarSource binarySumOfOnesSonarSource = new BinarySumOfOnesSonarSource();

        int result = binarySumOfOnesSonarSource.solution(3, 7);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binarySumOfOnesSonarSource.solution(2, 9);
        System.out.println(result);
        Assert.assertEquals(2, result);

        result = binarySumOfOnesSonarSource.solution(152, 14);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binarySumOfOnesSonarSource.solution(7731569, 7);
        System.out.println(result);
        Assert.assertEquals(14, result);

        result = binarySumOfOnesSonarSource.solution(1001687, 12);
        System.out.println(result);
        Assert.assertEquals(12, result);

        result = binarySumOfOnesSonarSource.solution(10, 10);
        System.out.println(result);
        Assert.assertEquals(3, result);

        result = binarySumOfOnesSonarSource.solution(10001542, 12000145);
        System.out.println(result);
        Assert.assertEquals(24, result);

        result = binarySumOfOnesSonarSource.solution(100000000, 100000000);
        System.out.println(result);
        Assert.assertEquals(20, result);
    }

    @Test
    public void testCornerCases() {
        BinarySumOfOnesSonarSource binarySumOfOnesSonarSource = new BinarySumOfOnesSonarSource();

        int result = binarySumOfOnesSonarSource.solution(0, 0);
        System.out.println(result);
        Assert.assertEquals(0, result);

        result = binarySumOfOnesSonarSource.solution(0, 1);
        System.out.println(result);
        Assert.assertEquals(0, result);

        result = binarySumOfOnesSonarSource.solution(1, 0);
        System.out.println(result);
        Assert.assertEquals(0, result);
    }
}
