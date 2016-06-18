package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class BeautifulStringsTest {

    @Test
    public void test() {
        Assert.assertEquals(152, BeautifulStrings.beautyRank("ABbCcc"));
        Assert.assertEquals(754, BeautifulStrings.beautyRank("Good luck in the Facebook Hacker Cup this year!"));
        Assert.assertEquals(491, BeautifulStrings.beautyRank("Ignore punctuation, please :)"));
        Assert.assertEquals(729, BeautifulStrings.beautyRank("Sometimes test cases are hard to make up."));
        Assert.assertEquals(646, BeautifulStrings.beautyRank("So I just go consult Professor Dalves"));
    }
}
