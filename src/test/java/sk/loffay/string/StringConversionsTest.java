package sk.loffay.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StringConversionsTest {

    @Test
    public void testStringToNumber() {
        Assert.assertEquals(0, StringConversions.toInteger("0"));
        Assert.assertEquals(0, StringConversions.toInteger("-0"));
        Assert.assertEquals(-1, StringConversions.toInteger("-1"));
        Assert.assertEquals(123, StringConversions.toInteger("123"));
        Assert.assertEquals(-123, StringConversions.toInteger("-123"));
    }

    @Test
    public void testNumberToString() {
        Assert.assertEquals("0", StringConversions.toString(0));
        Assert.assertEquals("2", StringConversions.toString(2));
        Assert.assertEquals("123", StringConversions.toString(123));
        Assert.assertEquals("-123", StringConversions.toString(-123));
        Assert.assertEquals("1236", StringConversions.toString(1236));
        Assert.assertEquals("-1236", StringConversions.toString(-1236));
    }
}
