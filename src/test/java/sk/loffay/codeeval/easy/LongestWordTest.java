package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class LongestWordTest {

    @Test
    public void test() {
        Assert.assertEquals("some", LongestWord.longestWord("some line with text"));
        Assert.assertEquals("another", LongestWord.longestWord("another line"));
        Assert.assertEquals("ab", LongestWord.longestWord("a ab"));
    }
}
