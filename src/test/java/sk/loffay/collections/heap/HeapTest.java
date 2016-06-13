package sk.loffay.collections.heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @author Pavol Loffay
 */
public class HeapTest {

    @Test
    public void testHeapInsert() {
        BinaryHeap<Integer> heap = new MaxMinBinaryHeap<>();

        Assert.assertEquals(null, heap.minMax());
        heap.insert(1);
        Assert.assertEquals(new Integer(1), heap.minMax());
        heap.insert(6);
        Assert.assertEquals(new Integer(6), heap.minMax());
    }

    @Test
    public void testMaxHeap() {
        Random random = new Random();
        BinaryHeap<Integer> heap = new MaxMinBinaryHeap<>();
        final int insertedSize = 1000;

        Multiset<Integer> multiSet = HashMultiset.create();

        for (int i = 0; i < insertedSize; i++) {
            Integer number = random.nextInt((int) (insertedSize/0.75));

            heap.insert(number);
            multiSet.add(number);

            /**
             * check if the heap properties
             * check if the heap contains all inserted elements
             */
            Integer[] array = heap.toArray(new Integer[0]);
            Assert.assertTrue(verifyHeap(array, false));
            Assert.assertTrue(containsAll(HashMultiset.create(multiSet), array));
        }

        Integer[] insertedIntegers = multiSet.toArray(new Integer[0]);
        Arrays.sort(insertedIntegers, (t1, t2) -> t2 - t1);
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(insertedIntegers));

        int removedCount = 0;
        Integer popFromHeap;
        while ((popFromHeap = heap.pop()) != null) {

            Integer removed = linkedList.remove();
            Assert.assertEquals(removed, popFromHeap);

            removedCount++;
        }

        Assert.assertEquals(insertedSize, removedCount);
    }

    @Test
    public void testMinHeap() {
        Random random = new Random();
        BinaryHeap<Integer> heap = new MaxMinBinaryHeap<>((t1, t2) -> t2 - t1);

        final int insertedSize = 1000;

        Multiset<Integer> multiSet = HashMultiset.create();

        for (int i = 0; i < insertedSize; i++) {
            Integer number = random.nextInt((int) (insertedSize/0.75));

            heap.insert(number);
            multiSet.add(number);

            /**
             * check if the heap properties
             * check if the heap contains all inserted elements
             */
            Integer[] array = heap.toArray(new Integer[0]);
            Assert.assertTrue(verifyHeap(array, true));
            Assert.assertTrue(containsAll(HashMultiset.create(multiSet), array));
        }

        Integer[] insertedIntegers = multiSet.toArray(new Integer[0]);
        Arrays.sort(insertedIntegers);
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(insertedIntegers));

        int removedCount = 0;
        Integer popFromHeap;
        while ((popFromHeap = heap.pop()) != null) {

            Integer removed = linkedList.remove();
            Assert.assertEquals(removed, popFromHeap);

            removedCount++;
        }

        Assert.assertEquals(insertedSize, removedCount);
    }


    public static <T> boolean containsAll(Multiset<T> multiset, T[] arr) {
        multiset.removeAll(Arrays.asList(arr));
        return multiset.isEmpty();
    }

    public static <T extends Comparable<T>> boolean verifyHeap(T[] arr, boolean minHeap) {

        for (int i = 1; i < arr.length; i++) {
            T parent = arr[BinaryHeap.parent(i)];

            if (minHeap) {
                if (arr[i].compareTo(parent) < 0) {
                    return false;
                }
            } else {
                if (arr[i].compareTo(parent) > 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
