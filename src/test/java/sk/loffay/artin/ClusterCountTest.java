package sk.loffay.artin;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class ClusterCountTest {

    @Test
    public void testClusterCount() {
        int[] array = new int[] {
                0,1,6,0,1,5,0
        };
        Assert.assertEquals(2, ClusterCount.clusterCount(array));

        array = new int[] {
        };
        Assert.assertEquals(0, ClusterCount.clusterCount(array));

        array = new int[] {
                1,2,6
        };
        Assert.assertEquals(1, ClusterCount.clusterCount(array));

        array = new int[] {
                1,2,6,0,6
        };
        Assert.assertEquals(2, ClusterCount.clusterCount(array));

        array = new int[] {
                0,1,2,6,0,6
        };
        Assert.assertEquals(2, ClusterCount.clusterCount(array));

        array = new int[] {
                0,1,2,0,0,0,0,6,0,6
        };
        Assert.assertEquals(4, ClusterCount.clusterCount(array));
    }

}
