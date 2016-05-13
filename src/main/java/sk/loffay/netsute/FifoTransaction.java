package sk.loffay.netsute;

/**
 * @author Pavol Loffay
 */
public class FifoTransaction {

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
