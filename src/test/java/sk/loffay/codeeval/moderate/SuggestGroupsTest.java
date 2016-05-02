package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author Pavol Loffay
 */
public class SuggestGroupsTest extends TestCase {

    @Test
    public void testCodeEval() throws FileNotFoundException {
        TestUtils.testMain("suggestedGroups", (arg) -> {
            try {
                SuggestGroups.main(arg);
            } catch (IOException ex) {
            }
        });
    }

}
