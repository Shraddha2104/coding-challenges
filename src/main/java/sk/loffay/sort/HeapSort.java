package sk.loffay.sort;

/**
 * @author Pavol Loffay
 *
 * Best =       N*log(N)
 * Average =    N*log(N)
 * Worst =      N*log(N)
 * Space comp = 1
 * Not stable - alg. does change position of elements with the same keys
 *
 * It is like Selection sort, but the highest value is always at the index 0
 *
 * Min Heap - ascending order (parent is always smaller than or equal to its child nodes)
 * Max Heap - descending order (parent is always greater than or equal to its child nodes)
 *
 * Heap max - root is the biggest element
 * Heap min - root is the smallest element
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {
        // move the greatest value to the top (index 0)
        heapify(arr);

        int index = arr.length - 1;
        while (index > 0) {
            // swap the top with latest element
            swap(arr, 0, index);
            index--;

            down(arr, index);
        }
    }

    private void heapify(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            up(arr, i);
        }
    }

    /**
     * Move if the element at index i is greater than parent move it to the top
     */
    private void up(T[] arr, int index) {
        while (index != 0) {
            int parentIndex = parentIndex(index);

            if (arr[parentIndex].compareTo(arr[index]) > 0) {
                break;
            }

            swap(arr, parentIndex, index);
            index = parentIndex;
        }
    }

    /**
     * Moves element(parent) down
     * if the child node is higher than root then swap it and go down
     */
    private void down(T[] arr, final int last) {
        int parent = 0;

        while (leftChild(parent) <= last) {
            int greaterChild = leftChild(parent);

            // id the right child is greater?
            if ((greaterChild < last) && (arr[greaterChild].compareTo(arr[rightChild(parent)]) < 0)) {
                greaterChild++;
            }

            if (arr[parent].compareTo(arr[greaterChild]) > 0) {
                 break;
            }

            swap(arr, parent, greaterChild);
            parent = greaterChild;
        }
    }


    private int leftChild(int parentIndex) {
        return parentIndex*2 + 1;
    }

    private int rightChild(int parentIndex) {
        return parentIndex*2 + 2;
    }

    private int parentIndex(int child) {
        return (child - 1)/2;
    }

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
