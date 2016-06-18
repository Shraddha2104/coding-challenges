package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SwapCaseTest {

    @Test
    public void test() {
        Assert.assertEquals("hELLO WORLD!", SwapCase.swapCase("Hello world!".toCharArray()));
        Assert.assertEquals("jAVAsCRIPT LANGUAGE 1.8", SwapCase.swapCase("JavaScript language 1.8".toCharArray()));
        Assert.assertEquals("a LETTER", SwapCase.swapCase("A letter".toCharArray()));
    }
}
