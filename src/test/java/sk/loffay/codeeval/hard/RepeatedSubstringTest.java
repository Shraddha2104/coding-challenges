package sk.loffay.codeeval.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class RepeatedSubstringTest {

    @Test
    public void test() {
        Assert.assertEquals("NONE", RepeatedSubstring.longestRepeatedSubstring(" "));
        Assert.assertEquals("NONE", RepeatedSubstring.longestRepeatedSubstring("  "));
        Assert.assertEquals("NONE", RepeatedSubstring.longestRepeatedSubstring(""));
        Assert.assertEquals("an", RepeatedSubstring.longestRepeatedSubstring("banana"));
        Assert.assertEquals("NONE", RepeatedSubstring.longestRepeatedSubstring("am so uniqe"));
        Assert.assertEquals("ana", RepeatedSubstring.longestRepeatedSubstring("banaanan"));
    }

    @Test
    public void testSpace() {
        Assert.assertEquals(true, RepeatedSubstring.isOnlySpace("  "));
        Assert.assertEquals(true, RepeatedSubstring.isOnlySpace(" "));
        Assert.assertEquals(false, RepeatedSubstring.isOnlySpace(""));
        Assert.assertEquals(false, RepeatedSubstring.isOnlySpace(" a"));
        Assert.assertEquals(false, RepeatedSubstring.isOnlySpace("a "));
    }
}
