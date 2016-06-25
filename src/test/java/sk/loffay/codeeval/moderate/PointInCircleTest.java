package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class PointInCircleTest {

    @Test
    public void test() {
        Assert.assertEquals(true, PointInCircle.pointInCircle("Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)"));
        Assert.assertEquals(false, PointInCircle.pointInCircle("Center: (5.05, -11); Radius: 21.2; Point: (-31, -45)"));
        Assert.assertEquals(true, PointInCircle.pointInCircle("Center: (-9.86, 1.95); Radius: 47.28; Point: (6.03, -6" +
                ".42)"));
    }
}
