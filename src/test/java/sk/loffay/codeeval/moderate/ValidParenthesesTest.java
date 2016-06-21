package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ValidParenthesesTest {

    @Test
    public void test() {
        Assert.assertEquals(true, ValidParentheses.validParenthesis("()"));
        Assert.assertEquals(false, ValidParentheses.validParenthesis("([)"));
    }
}
