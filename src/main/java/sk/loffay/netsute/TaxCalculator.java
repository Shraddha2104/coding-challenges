package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 */
public class TaxCalculator {

    /**
     * Calculate tax
     * @param income
     * @param taxBrackets, index 0 = minimum, index 1 = rate
     * @return
     */
    public static double taxCalculator(double income, double[][] taxBrackets) {

        double tax = 0;

        for (int i = 0; i < taxBrackets.length && income > 0; i++) {

            double limit = taxBrackets[i][0];
            double rate = taxBrackets[i][1];

            double range = i + 1 < taxBrackets.length ? taxBrackets[i+1][0] - limit : income+limit;

            if (income >= range) {
                tax += range*rate;
            } else {
                tax += income*rate;
            }

            income = income - range;
        }

        return tax;
    }
}
