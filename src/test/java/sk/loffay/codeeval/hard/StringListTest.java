package sk.loffay.codeeval.hard;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StringListTest {

    @Test
    public void test() {
        Assert.assertEquals("a", evaluationWrapper("aa", 1));
        Assert.assertEquals("aa,ab,ba,bb", evaluationWrapper("ab", 2));
        Assert.assertEquals("ooo,oop,opo,opp,poo,pop,ppo,ppp", evaluationWrapper("pop", 3));
    }

    private String evaluationWrapper(String letters, int length) {
        Set<String> words = StringList.stringList(StringList.stringToSet(letters), length);
        return StringList.toStringForCodeeval(words);
    }
}
