package sk.loffay;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
@Ignore
public class DictionaryGeneratorTest {

    @Test
    public void testWriteWordsToStdout() throws IOException {
        List<String> words = DictionaryGenerator.parseWords();
        Assert.assertTrue(words.size() > 1000);

        for (String word: words) {
            System.out.println("\"" + word + "\"" + ",");
        }
    }
}
