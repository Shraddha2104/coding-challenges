package sk.loffay.codeeval.moderate;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;
import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
public class SuggestGroupsTest extends TestCase {

    @Test
    public void testCodeEval() throws FileNotFoundException {
        CodeevalTestUtils.testMain("moderate/suggestedGroups", (arg) -> {
            try {
                SuggestGroups.main(arg);
            } catch (IOException ex) {
            }
        });
    }

}
