package sk.loffay.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import sk.loffay.Utils;

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

        List<Integer> inOrder = TreeTraversals.inOrder(tree.getRoot());
        Assert.assertTrue(Utils.isSorted(inOrder, true));

        List<Integer> preOrder = TreeTraversals.preOrder(tree.getRoot());
        Assert.assertTrue(Utils.isPreOrder(preOrder));
        Assert.assertTrue(tree.isBalanced());

        List<Integer> bfsOrder = TreeTraversals.breadthFirstSearch(tree.getRoot());
        Assert.assertArrayEquals(new Integer[]{4, 2, 7, 1, 3, 6, 32, 15, 99}, bfsOrder.toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[]{4, 2, 7, 1, 3, 6, 32, 15, 99},
                TreeTraversals.breadthFirstSearchIterative(tree.getRoot()).toArray(new Integer[0]));
    }

    @Test
    public void testRandom() {

        Random rand = new Random();
        AvlTree<Integer, String> tree = new AvlTree<>();

        Set<Integer> added = new HashSet<>(200);

        for (int i = 0; i < 533; i++) {
            int randomNum = rand.nextInt(533);

//            System.out.println("inserting: " + randomNum + ", to tree:");
//            tree.print();

            tree.insertRecursive(randomNum, "foo");
            added.add(randomNum);

//            System.out.println("tree after inserted:" + randomNum);
//            tree.print();

            Assert.assertTrue(Utils.isSorted(TreeTraversals.inOrderStack(tree.getRoot()), true));
            Assert.assertTrue(Utils.isPreOrder(TreeTraversals.preOrderStack(tree.getRoot())));
            Assert.assertTrue(Utils.isPostOrder(TreeTraversals.postOrder(tree.getRoot())));
            Assert.assertTrue("not balanced for: " + added.toString(), tree.isBalanced());
        }
    }
}
