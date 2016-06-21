package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
public class StringRotationTest {

    @Test
    public void test() {
        Assert.assertEquals(true, StringRotation.isRotation("Hello", "lloHe"));
        Assert.assertEquals(true, StringRotation.isRotation("Basefont", "tBasefon"));
        Assert.assertEquals(true, StringRotation.isRotation("6VGy0u3ZR9i4hLT056weUXXxFg", "Gy0u3ZR9i4hLT056weUXXxFg6V"));
    }

    @Test
    public void testCodeEval() throws FileNotFoundException {
        CodeevalTestUtils.testMain("moderate/stringRotation", (arg) -> {
            try {
                StringRotation.main(arg);
            } catch (IOException ex) {
            }
        });
    }
}
