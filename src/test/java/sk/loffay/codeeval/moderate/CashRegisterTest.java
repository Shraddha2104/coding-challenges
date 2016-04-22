package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class CashRegisterTest extends TestCase {

    @Test
    public void testCodeEval() throws FileNotFoundException {
        TestUtils.testMain("cashRegister", (arg) -> {
            try {
                CashRegister.main(arg);
            } catch (IOException ex) {
            }
        });
    }

}
