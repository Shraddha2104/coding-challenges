package sk.loffay.collections.heap;

/**
 * @author Pavol Loffay
 */
public interface BinaryHeap<Type extends Comparable<Type>> {

    /**
     * Create Binary Heap
     * best implementation is O(n)
     * https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
     */

    /**
     * Time log(n)
     */
    void insert(Type element);

    /**
     * Time O(n)
     */
    Type minMax();

    /**
     * Time O(log(n))
     */
    Type pop();

    <T> T[] toArray(T[] type);


    static int leftChild(int parent) {
        return parent*2 + 1;
    }

    static int rightChild(int parent) {
        return parent*2 + 2;
    }

    static int parent(int child) {
        return (child - 1)/2;
    }

}
