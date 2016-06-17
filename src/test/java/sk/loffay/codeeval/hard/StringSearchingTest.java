package sk.loffay.codeeval.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StringSearchingTest {

    @Test
    public void test() {
        Assert.assertEquals(false, StringSearching.isSubstring("", "ello"));
        Assert.assertEquals(true, StringSearching.isSubstring("", "*"));
        Assert.assertEquals(false, StringSearching.isSubstring("", "a*"));
        Assert.assertEquals(false, StringSearching.isSubstring("", "*a"));
        Assert.assertEquals(false, StringSearching.isSubstring("", "a*a"));

        Assert.assertEquals(true, StringSearching.isSubstring("ello", "el*lo"));
        Assert.assertEquals(true, StringSearching.isSubstring("ello", "el***lo"));
        Assert.assertEquals(false, StringSearching.isSubstring("ello", "fl***lo"));

        Assert.assertEquals(false, StringSearching.isSubstring("ab*cd", "abcd"));
        Assert.assertEquals(true, StringSearching.isSubstring("ab*cd", "ab\\*cd"));

        Assert.assertEquals(true, StringSearching.isSubstring("efllor", "fllo**"));

        Assert.assertEquals(true, StringSearching.isSubstring("Hello", "ello"));
        Assert.assertEquals(true, StringSearching.isSubstring("This is good", "is"));
        Assert.assertEquals(true, StringSearching.isSubstring("CodeEval", "C*Eval"));
        Assert.assertEquals(false, StringSearching.isSubstring("Old", "Young"));
    }
}
