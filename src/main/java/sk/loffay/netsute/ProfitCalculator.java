package sk.loffay.netsute;

import java.util.List;

/**
 * @author Pavol Loffay
 */
public class ProfitCalculator {

    /**
     * Calculate profit of the FIFO transactions.
     * @param transactions
     * @return profit
     */
    public static double calculateProfit(List<FifoTransaction> transactions) {

        int quantity = 0;
        double profit = 0;

        // calculated sold items
        for (FifoTransaction trans: transactions) {
            if (!trans.isPurchase()) {
                // is sale
                quantity += trans.getQuantity();
                profit += trans.getQuantity()*trans.getItemPrice();
            }
        }

        for (FifoTransaction trans: transactions) {
            if (quantity == 0) {
                break;
            }

            if (trans.isPurchase()) {
                int q = trans.getQuantity() >= quantity ? quantity : trans.getQuantity();
                profit -= q*trans.getItemPrice();
            }
        }

        return profit;
    }

    public static class FifoTransaction {

        private boolean purchase;
        private double itemPrice;
        private int quantity;


        public FifoTransaction(boolean purchase, double itemPrice, int quantity) {
            this.purchase = purchase;
            this.itemPrice = itemPrice;
            this.quantity = quantity;
        }

        public boolean isPurchase() {
            return purchase;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
