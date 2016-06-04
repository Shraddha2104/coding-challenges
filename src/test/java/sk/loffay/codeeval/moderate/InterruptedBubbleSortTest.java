package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
public class InterruptedBubbleSortTest {

    @Test
    public void test() throws FileNotFoundException {
        CodeevalTestUtils.testMain("moderate/interruptedBubbleSort", (args) -> {
            try {
                InterruptedBubbleSort.main(args);
            } catch (IOException ex) {
            }
        });
    }
}
