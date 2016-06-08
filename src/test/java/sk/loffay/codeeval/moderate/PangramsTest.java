package sk.loffay.codeeval.moderate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class PangramsTest {

    @Test
    public void test() {
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", Pangrams.panagrams(""));
        Assert.assertEquals("NULL", Pangrams.panagrams("A quick brown fox jumps over the lazy dog"));
        Assert.assertEquals("bjkmqz", Pangrams.panagrams("A slow yellow fox crawls under the proactive dog"));
    }
}
