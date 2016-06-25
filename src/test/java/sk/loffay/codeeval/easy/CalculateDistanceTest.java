package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class CalculateDistanceTest {

    @Test
    public void test() {
        Assert.assertEquals(26, CalculateDistance.distance("(25, 4) (1, -6)"));
        Assert.assertEquals(90, CalculateDistance.distance("(47, 43) (-25, -11)"));
    }
}
