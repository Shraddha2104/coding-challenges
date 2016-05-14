package sk.loffay.netsute;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
//        tree.insert(4, "string");
//        tree.insert(32, "string");
//        tree.insert(6, "string");
//        tree.insert(7, "string");
//        tree.insert(99, "string");
//        tree.insert(15, "string");

        tree.print();
        tree.inOrderPrint();

        Assert.assertTrue(tree.isBalanced());
    }

    @Test
    public void tesOne() {
        int[] arr = new int[] {
                279, 187, 21, 254, 97, 178
        };

        AvlTree<Integer, String> tree = new AvlTree<>();

        for (int key: arr) {
            tree.insert(key, "foo");

            tree.print();
            System.out.println("Inserting:" + key);
            Assert.assertTrue(Arrays.toString(arr), tree.isBalanced());
        }

    }

    @Test
    public void testAutonomous() {

        Random rand = new Random();
        AvlTree<Integer, String> tree = new AvlTree<>();

        Set<Integer> added = new HashSet<>(200);

        for (int i = 0; i < 5000; i++) {
            int randomNum = rand.nextInt(300);

            System.out.println("inserting: " + randomNum + ", to tree:");
//            tree.print();

            tree.insert(randomNum, "foo");
            added.add(randomNum);
            System.out.println("tree after inserted:" + randomNum);
//            tree.print();

            if (!tree.isBalanced()) {
                System.out.println("NOT BALANCED");
            }
            Assert.assertTrue(Arrays.toString(added.toArray()),tree.isBalanced());
        }
    }
}
