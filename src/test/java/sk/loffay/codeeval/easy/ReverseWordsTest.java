package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ReverseWordsTest {

    @Test
    public void test() {
        Assert.assertEquals("", ReverseWords.reverseWords("".toCharArray()));
        Assert.assertEquals("World Hello", ReverseWords.reverseWords("Hello World".toCharArray()));
        Assert.assertEquals("CodeEval Hello", ReverseWords.reverseWords("Hello CodeEval".toCharArray()));
        Assert.assertEquals("CodeEval Hello  tata", ReverseWords.reverseWords("tata  Hello CodeEval".toCharArray()));
    }
}
