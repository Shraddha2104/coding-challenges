package sk.loffay.sort;

/**
 * @author Pavol Loffay
 *
 * Min Heap - ascending order (parent is always smaller than or equal to its child nodes)
 * Max Heap - descending order (parent is always greater than or equal to its child nodes)
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] arr) {

    }

    private int leftIndex(int parentIndex) {
        return parentIndex*2 + 1;
    }

    private int rightIndex(int parentIndex) {
        return parentIndex*2 + 2;
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
