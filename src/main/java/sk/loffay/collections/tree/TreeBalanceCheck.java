package sk.loffay.collections.tree;

/**
 * @author Pavol Loffay
 */
public class TreeBalanceCheck {

    public static int checkBalance(AvlTree.Node node){
        if (node == null) {
            return 0;
        }
        int left = checkBalance(node.left);

        if (left == -1) {
            return -1;
        }

        int right = checkBalance(node.right);

        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}
