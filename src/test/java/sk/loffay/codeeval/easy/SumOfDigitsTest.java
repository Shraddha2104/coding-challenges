package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SumOfDigitsTest {

    @Test
    public void test() {
        Assert.assertEquals(6, SumOfDigits.sumOfDigitsFromString("123"));
    }
}
