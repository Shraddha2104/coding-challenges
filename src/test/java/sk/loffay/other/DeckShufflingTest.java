package sk.loffay.other;

import java.util.Arrays;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class DeckShufflingTest {

    @Test
    public void test() {
        Integer[] arr = new Integer[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9
        };

        Integer[] copyOf = Arrays.copyOf(arr, arr.length);

        DeckShuffling.shuffle(arr);

        Assert.assertThat(arr, IsNot.not(IsEqual.equalTo(copyOf)));
    }
}
