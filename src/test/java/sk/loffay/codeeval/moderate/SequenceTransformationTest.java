package sk.loffay.codeeval.moderate;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
@Ignore
public class SequenceTransformationTest {

    @Test
    public void test() {
        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("11", "AA"));
        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("11", "AAB"));
        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("1010", "AAAAABBBBAAAA"));
        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("00", "AAAAAA"));
        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("01001110", "AAAABAAABBBBBBAAAAAAA"));
        Assert.assertEquals(false, SequenceTransformation.canBeTransformed("1100110", "BBAABABBA"));
    }

    @Test
    public void testOne() {
        Assert.assertEquals(true, SequenceTransformation.canBeTransformedRegex("100111111110101110111001000001010100001010100000101111110111010010010000110010110010010010111001111111011101011000100000100110011011101110", "AAAAAAAAAABBBBBBBBAAAAAABBBBBBBBBBBAAAABBBAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBAAAAAAAAABAAAAAAAABAABBABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAABBBBBBBAAAAAABBAAABBBBBBBBBBBBBBBAAABBBBBBAAAAAAAAABBAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBAAAAAAAAAABBBBBBBBBBBBBBAAAAAAAAAAAAAABBBBBBBBBAAAAAAAAAABBBAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAABBBBBBAAAAAAAAAAAAABBBBAAAAAAAAAAAAAAAAAABBBBAAAAAAAAAAAABBBBBA"));
//        Assert.assertEquals(true, SequenceTransformation.canBeTransformed("101", "BBBBBBBBBAAAA"));
    }

    @Test
    public void testCanRemove() {
//        Assert.assertEquals(true, SequenceTransformation.canRemove("11", "AA", 1));
//        Assert.assertEquals(false, SequenceTransformation.canRemove("11", "AA", 2));
//        Assert.assertEquals(false, SequenceTransformation.canRemove("11", "AA", 3));
//        Assert.assertEquals(true, SequenceTransformation.canRemove("1", "A", 1));
//        Assert.assertEquals(false, SequenceTransformation.canRemove("0", "B", 1));
        Assert.assertEquals(true, SequenceTransformation.canRemove("110", "ABBAAAAABAABBBBAB", 1));
    }

    @Test
    public void testMain() throws IOException {
        SequenceTransformation.main(new String[]{"/home/pavol/projects/sonar-source-interview-codility/src/test/resources/codeeval/moderate/sequenceTransformation"});
    }

    @Test
    public void a() {

    }
}
