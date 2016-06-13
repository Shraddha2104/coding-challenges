package sk.loffay.collections.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavol Loffay
 */
public class MaxMinBinaryHeap<Type extends Comparable<Type>> implements BinaryHeap<Type> {

    private Object[] arr;
    // aim at first empty item
    private int size;
    private Comparator<Type> comparator;


    public MaxMinBinaryHeap() {
        this.size = 0;
        arr = new Object[50];
    }

    public MaxMinBinaryHeap(Comparator<Type> comparator) {
        this.comparator = comparator;
        this.size = 0;
        arr = new Object[50];
    }

    public MaxMinBinaryHeap(Type[] arr) {
        this(arr, null);
    }

    public MaxMinBinaryHeap(Type[] arr, Comparator<Type> comparator) {
        this.comparator = comparator;
        size = 0;
        heapify(arr);
    }

    @Override
    public void insert(Type element) {
        if (size == arr.length - 1) {
            arr = Arrays.copyOf(arr, size*2);
        }

        arr[size] = element;
        siftUp(arr, size);
        size++;
    }

    @Override
    public Type minMax() {
        return (Type) arr[0];
    }

    @Override
    public Type pop() {
        if (size == 0) {
            return null;
        }

        /**
         * 1. return first item
         * 2. move last item to the top (index 0)
         * 3. shift down from index 0
         */
        Type toReturn = (Type) arr[0];
        swap(arr, 0, size-1);
        arr[size-1] = null;
        size--;

        siftDown(arr, 0);
        return toReturn;
    }

    @Override
    public <T> T[] toArray(T[] type) {
        List<String> list = new ArrayList<>();
        list.toArray(new String[0]);
        return (T[]) Arrays.copyOf(arr, this.size, type.getClass());
    }

    /**
     * Construct heap property
     * Time O(log(n)) can be done in O(n)
     */
    private void heapify(Type[] arr) {
        for (int i = 0; i < arr.length; i++) {
            siftUp(arr, i);
        }
    }

    /**
     * move a node up in the tree, as long as needed; used to restore heap
     * condition after insertion. Called "sift" because node moves up the
     * tree until it reaches the correct level, as in a sieve.
     *
     * // starts at end and goes to parent
     */
    private void siftUp(Object[] arr, int index) {
        while (index > 0) {
            final int parentIndex = BinaryHeap.parent(index);

            if (compare(arr, index, parentIndex) < 0) {
                break;
            }

            swap(arr, index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * move a node down in the tree, similar to shift-up; used to restore
     * heap condition after deletion or replacement.
     */
    private void siftDown(Object[] arr, int parent) {
        int greaterChild = BinaryHeap.leftChild(parent);
        while (greaterChild < size) {
            // id the right child is greater?
            if (greaterChild+1 < size && compare(arr, greaterChild, BinaryHeap.rightChild(parent)) < 0) {
                greaterChild = BinaryHeap.rightChild(parent);
            }

            if (compare(arr, parent, greaterChild) > 0) {
                break;
            }

            swap(arr, parent, greaterChild);
            parent = greaterChild;
            greaterChild = BinaryHeap.leftChild(parent);
        }
    }

    private void swap(Object arr[], int i, int j) {
        Object temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private int compare(Object[] arr, int i, int j) {
        if (comparator != null) {
            return comparator.compare((Type) arr[i], (Type) arr[j]);
        }

        return ((Type)arr[i]).compareTo((Type) arr[j]);
    }
}
