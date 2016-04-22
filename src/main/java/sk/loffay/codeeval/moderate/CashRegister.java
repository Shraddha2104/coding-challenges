package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 51.399
 * mem: 8482816
 */
public class CashRegister {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Params params = parseLine(line);

            List<BillCoin> result = cashRegister(params.purchasePrice, params.cash);
            if (result == null) {
                System.out.println("ERROR");
                continue;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (BillCoin billCoin: result) {
                stringBuilder.append(billCoin.name).append(",");
            }

            System.out.println(stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length())
                    .toString().trim());
        }
    }

    private static List<BillCoin> cashRegister(double price, double cash) {
        double balance = cash - price;
        balance = round(balance, 2);

        if (balance < 0) {
            return null;
        } else if (balance == 0) {
            return Collections.singletonList(BillCoin.ZERO);
        }

        List<BillCoin> result = new ArrayList<>();

        for (BillCoin bill: BillCoin.allDefined) {
            double balancePart = balance/bill.value;
            if (balancePart >= 1) {
                balance = round(balance -  bill.value*((long)balancePart), 2);

                for (int i = 0; i < ((long)balancePart); i++) {
                    result.add(bill);
                }
            }
        }

        return result;
    }

    private static Params parseLine(String line) {
        String[] split = line.split(";");

        double purchasePrice = Double.parseDouble(split[0].trim());
        double cash = Double.parseDouble(split[1].trim());

        return new Params(purchasePrice, cash);
    }

    private static class Params {
        final double purchasePrice;
        final double cash;

        public Params(double purchasePrice, double cash) {
            this.purchasePrice = purchasePrice;
            this.cash = cash;
        }
    }

    private enum BillCoin {
        ZERO(0, "ZERO"),
        PENNY(0.01, "PENNY"),
        NICKEL(0.05, "NICKEL"),
        DIME(0.10, "DIME"),
        QUARTER(0.25, "QUARTER"),
        HALF_DOLLAR(0.5, "HALF DOLLAR"),
        ONE(1, "ONE"),
        TWO(2, "TWO"),
        FIVE(5, "FIVE"),
        TEN(10, "TEN"),
        TWENTY(20, "TWENTY"),
        FIFTY(50, "FIFTY"),
        ONE_HUNDRED(100, "ONE HUNDRED");

        private double value;
        private String name;

        BillCoin(double value, String name) {
            this.value = value;
            this.name = name;
        }

        private static BillCoin[] allDefined = {ONE_HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE, HALF_DOLLAR,
                QUARTER, DIME, NICKEL, PENNY};
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
