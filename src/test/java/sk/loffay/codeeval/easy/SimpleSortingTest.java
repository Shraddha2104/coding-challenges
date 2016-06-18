package sk.loffay.codeeval.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class SimpleSortingTest {

    @Test
    public void test() {
        Assert.assertEquals("-38.797 7.581 14.354 70.920 90.374 99.323", SimpleSorting.simpleSorting("70.920 -38.797 " +
                "14.354 99.323 90.374 7.581"));
        Assert.assertEquals("-55.552 -37.507 -3.263 27.999 40.079 65.213", SimpleSorting.simpleSorting("-37.507 -3.263 40.079 27.999 65.213 -55.552"));
    }
}
