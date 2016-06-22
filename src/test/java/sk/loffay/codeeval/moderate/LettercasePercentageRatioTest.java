package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class LettercasePercentageRatioTest {

    @Test
    public void test() {
        Assert.assertEquals(50.00, LettercasePercentageRatio.lowerCasePercentage("thisTHIS"), 0.001);
        Assert.assertEquals(20.00, LettercasePercentageRatio.lowerCasePercentage("AAbbCCDDEE"), 0.001);
        Assert.assertEquals(00.00, LettercasePercentageRatio.lowerCasePercentage("N"), 0.001);
        Assert.assertEquals(33.33, LettercasePercentageRatio.lowerCasePercentage("UkJ"), 0.01);
    }
}
