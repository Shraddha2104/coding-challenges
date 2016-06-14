package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class OverlappingRectanglesTest {

    @Test
    public void test() {
        Assert.assertEquals(false, OverlappingRectangles.parseAndTestOverlap("-3,3,-1,1,1,-1,3,-3"));
        Assert.assertEquals(true, OverlappingRectangles.parseAndTestOverlap("-3,3,-1,1,-2,4,2,2"));
    }
}
