package sk.loffay.codeeval.moderate;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import sk.loffay.codeeval.CodeevalTestUtils;

/**
 * @author Pavol Loffay
 */
public class ColumnNamesTest {

    @Test
    public void testColumnNames() {
        Assert.assertEquals("A", ColumnNames.toExcel(1));
        Assert.assertEquals("Z", ColumnNames.toExcel(26));

        Assert.assertEquals("AA", ColumnNames.toExcel(27));
        Assert.assertEquals("AD", ColumnNames.toExcel(30));
        Assert.assertEquals("AZ", ColumnNames.toExcel(52));
        Assert.assertEquals("CZ", ColumnNames.toExcel(104));
        Assert.assertEquals("DA", ColumnNames.toExcel(105));
        Assert.assertEquals("ZY", ColumnNames.toExcel(701));
        Assert.assertEquals("ZZ", ColumnNames.toExcel(702));

        Assert.assertEquals("AAA", ColumnNames.toExcel(703));
        Assert.assertEquals("AAB", ColumnNames.toExcel(704));
        Assert.assertEquals("ABA", ColumnNames.toExcel(729));
        Assert.assertEquals("ABB", ColumnNames.toExcel(730));
        Assert.assertEquals("ACW", ColumnNames.toExcel(777));
        Assert.assertEquals("ELJ", ColumnNames.toExcel(3702));
        Assert.assertEquals("AMJ", ColumnNames.toExcel(1024));

        Assert.assertEquals("ADV", ColumnNames.toExcel(802));
        Assert.assertEquals("SBV", ColumnNames.toExcel(12918));
        Assert.assertEquals("AAZ", ColumnNames.toExcel(728));
        Assert.assertEquals("FQZ", ColumnNames.toExcel(4524));
    }

    @Test
    public void testMain() throws IOException {
        CodeevalTestUtils.testMain("moderate/columnNames", (args) -> {
            try {
                ColumnNames.main(args);
            } catch (IOException ex) {
            }
        });
    }
}
