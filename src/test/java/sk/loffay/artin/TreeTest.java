package sk.loffay.artin;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class TreeTest {

    @Test
    public void testSum() {
        Tree.Node root = new Tree.Node(2);
        Tree.Node left = new Tree.Node(3);
        Tree.Node right = new Tree.Node(6);

        Tree.Node leftLeft = new Tree.Node(35);
        Tree.Node leftRight = new Tree.Node(774);

        Tree.Node rightLeft = new Tree.Node(-57);
        Tree.Node rightRight = new Tree.Node(77);

        Tree.Node leftLeftLeft = new Tree.Node(741);
        Tree.Node leftLeftLeftLeft = new Tree.Node(7111);

        root.addChildren(left);
        root.addChildren(right);

        left.addChildren(leftLeft);
        left.addChildren(leftRight);

        right.addChildren(rightLeft);
        right.addChildren(rightRight);

        leftLeft.addChildren(leftLeftLeft);
        leftLeftLeft.addChildren(leftLeftLeftLeft);

        Assert.assertEquals(2, Tree.valuesSum(root, 0));
        Assert.assertEquals(11, Tree.valuesSum(root, 1));
        Assert.assertEquals(840, Tree.valuesSum(root, 2));
        Assert.assertEquals(1581, Tree.valuesSum(root, 3));
        Assert.assertEquals(8692, Tree.valuesSum(root, 4));
    }
}
