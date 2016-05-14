package sk.loffay.netsute;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Pavol Loffay
 */
public class AvlTreeTest {

    @Test
    public void test() {
        AvlTree<Integer, String> tree = new AvlTree<>();

        tree.insert(1, "string");
        tree.insert(2, "string");
        tree.insert(3, "string");
        tree.insert(4, "string");
        tree.insert(32, "string");
        tree.insert(6, "string");
        tree.insert(7, "string");
        tree.insert(99, "string");
        tree.insert(15, "string");

        tree.print();
        tree.inOrderPrint();

        Assert.assertTrue(tree.isBalanced());
    }

    @Test
    public void testAutonomous() {

        AvlTree<Integer, String> tree = new AvlTree<>();

        Random rand = new Random();
        for (int i = 0; i < 300; i++) {
            int randomNum = rand.nextInt(300);

            tree.insert(randomNum, "foo");

            System.out.println("inserted: " + randomNum);
            tree.print();
            Assert.assertTrue(tree.isBalanced());
        }
    }
}
