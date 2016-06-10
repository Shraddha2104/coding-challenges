package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class CardNumberValidationTest {

    @Test
    public void test() {
        Assert.assertEquals(false, CardNumberValidation.creditCardIsValid(new int[] {5,5,7,4,8,3,6,3,8,0,2,2,9,7,3,5}));
        Assert.assertEquals(false, CardNumberValidation.creditCardIsValid(new int[] {3,0,4,4,8,5,0,7,9,3,9,1,3,0}));
        Assert.assertEquals(false, CardNumberValidation.creditCardIsValid(new int[] {6,0,1,1,5,9,4,0,0,3,1,9,9,5,1,1}));
        Assert.assertEquals(true, CardNumberValidation.creditCardIsValid(new int[] {1,5,5,6,9,1,4,4,6,2,8,5,3,3,9}));
        Assert.assertEquals(true, CardNumberValidation.creditCardIsValid(new int[] {5,5,3,7,0,2,1,3,6,7,9,7,6,8,1,5}));
        Assert.assertEquals(true, CardNumberValidation.creditCardIsValid(new int[] {6,3,7,0,1,6,7,5,9,0,3,4,6,2,1,1,
                7,7,4}));
    }
}
