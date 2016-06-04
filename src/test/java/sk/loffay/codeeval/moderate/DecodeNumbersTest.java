package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class DecodeNumbersTest {

    @Test
    public void testDecode() {
        Assert.assertEquals(2, DecodeNumbers.decode("12"));
        Assert.assertEquals(3, DecodeNumbers.decode("123"));
        Assert.assertEquals(6, DecodeNumbers.decode("122925"));
    }
}
