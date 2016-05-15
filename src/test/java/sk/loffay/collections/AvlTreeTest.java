package sk.loffay.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

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

        List<Integer> inOrder = TreeTraversals.inOrder(tree.getRoot());
        System.out.println(inOrder);
        assertOrdered(inOrder, true);

        List<Integer> preOrder = TreeTraversals.preOrder(tree.getRoot());
        assertPreOrder(preOrder);
        System.out.println(preOrder);

        Assert.assertTrue(tree.isBalanced());
    }

    @Test
    public void testAutonomous() {

        Random rand = new Random();
        AvlTree<Integer, String> tree = new AvlTree<>();

        Set<Integer> added = new HashSet<>(200);

        for (int i = 0; i < 5000; i++) {
            int randomNum = rand.nextInt(5000);

//            System.out.println("inserting: " + randomNum + ", to tree:");
//            tree.print();

            tree.insertRecursive(randomNum, "foo");
            added.add(randomNum);

//            System.out.println("tree after inserted:" + randomNum);
//            tree.print();

            assertOrdered(TreeTraversals.inOrderStack(tree.getRoot()), true);
            Assert.assertTrue("not balanced for: " + added.toString(), tree.isBalanced());
        }

        System.out.println(Arrays.toString(TreeTraversals.inOrder(tree.getRoot()).toArray()));
    }

    public static <T extends Comparable<T>> void assertOrdered(List<T> values, boolean ascending) {

        Comparable<? extends T> previous = null;

        for(Comparable val: values) {

            if (previous != null) {
                boolean result = ascending ? val.compareTo(val) > 0 : val.compareTo(val) < 0;
                if (result) {
                    Assert.fail("items nor ordered");
                }
            }

            previous = val;
        }
    }

    public static <T extends Comparable<T>> void assertPreOrder(List<T> preOrder) {

        Stack<Comparable<T>> stack = new Stack<>();
        Comparable<T> lower = null;

        for(int i = 0; i < preOrder.size() ;i++) {
            if(lower != null && lower.compareTo(preOrder.get(i)) > 0) {
                Assert.fail("not preOrder");
            }
            while(!stack.isEmpty() && stack.peek().compareTo(preOrder.get(i)) < 0) {
                lower = stack.pop();
            }
            stack.push(preOrder.get(i));
        }
    }
}
