package sk.loffay.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class StringReverseTest {

    @Test
    public void reverseString() {
        Assert.assertEquals("", new String(StringReverse.reverse("".toCharArray())));
        Assert.assertEquals("a", new String(StringReverse.reverse("a".toCharArray())));
        Assert.assertEquals("ab", new String(StringReverse.reverse("ba".toCharArray())));
        Assert.assertEquals("abc", new String(StringReverse.reverse("cba".toCharArray())));
        Assert.assertEquals("joha", new String(StringReverse.reverse("ahoj".toCharArray())));
    }

    @Test
    public void reverseWords() {
        Assert.assertEquals("", new String(StringReverse.reverseWords("".toCharArray())));
        Assert.assertEquals("a", new String(StringReverse.reverseWords("a".toCharArray())));
        Assert.assertEquals("Z Y X is name My", new String(StringReverse.reverseWords("My name is X Y Z".toCharArray())));
        Assert.assertEquals("ahoj Janka", new String(StringReverse.reverseWords("Janka ahoj".toCharArray())));
    }
}
