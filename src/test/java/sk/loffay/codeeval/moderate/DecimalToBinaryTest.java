package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class DecimalToBinaryTest {

    @Test
    public void test() {
        Assert.assertEquals("0" ,DecimalToBinary.intToBinary(0));
        Assert.assertEquals("1" ,DecimalToBinary.intToBinary(1));
        Assert.assertEquals("10" ,DecimalToBinary.intToBinary(2));
        Assert.assertEquals("1010" ,DecimalToBinary.intToBinary(10));
        Assert.assertEquals("1000011" ,DecimalToBinary.intToBinary(67));
    }
}
