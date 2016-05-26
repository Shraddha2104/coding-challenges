package sk.loffay.netsute;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class TaxCalculatorTest {

    @Test
    public void testTaxCalculator() {
        double[][] taxBrackets = new double[][] {
                {0, 0.10},
                {10000, 0.15},
                {25000, 0.20},
                {30000, 0.25}
        };

        double income = 5000;
        double tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(500, tax, 0.1);

        income = 10000;
        tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(1000, tax, 0.1);

        income = 15000;
        tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(1000 + 750, tax, 0.1);

        income = 25000;
        tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(1000 + 2250, tax, 0.1);

        income = 27000;
        tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(1000 + 2250 + 400, tax, 0.1);

        income = 45000;
        tax = TaxCalculator.taxCalculator(income, taxBrackets);
        Assert.assertEquals(1000 + 2250 + 1000 + 3750, tax, 0.1);
    }

}
