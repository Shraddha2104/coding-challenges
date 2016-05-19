package sk.loffay.codeeval.moderate;

import java.io.IOException;

import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class DataRecoveryTest {

    @Test
    public void testMain() throws IOException {
        CodeevalTestUtils.testMain("moderate/DataRecovery", (args) -> {
            try {
                DataRecovery.main(args);
            } catch (IOException ex) {
            }
        });
    }


}
