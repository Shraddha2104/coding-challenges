package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class CleanUpTheWordsTest {

    @Test
    public void test() {
        Assert.assertEquals("a a r", CleanUpTheWords.cleanSentence("a--a44r"));
    }

}
