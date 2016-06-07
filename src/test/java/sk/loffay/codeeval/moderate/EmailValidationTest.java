package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class EmailValidationTest {

    @Test
    public void testValid() {
        Assert.assertEquals(true, EmailValidation.isEmailValid("p.loffay@gmail.com"));
        Assert.assertEquals(true, EmailValidation.isEmailValid("ploffay@gmail.com"));
        Assert.assertEquals(true, EmailValidation.isEmailValid("paa@gaa.caa"));
        Assert.assertEquals(true, EmailValidation.isEmailValid("p.9.9@g.caa"));
        Assert.assertEquals(true, EmailValidation.isEmailValid("p@gaa.caa"));
    }

    @Test
    public void testInvalid() {
        Assert.assertEquals(false, EmailValidation.isEmailValid(""));
        Assert.assertEquals(false, EmailValidation.isEmailValid("admin#codeeval.com"));
        Assert.assertEquals(false, EmailValidation.isEmailValid("this is not an email id"));
    }
}
