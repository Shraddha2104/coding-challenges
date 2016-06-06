package sk.loffay.sort;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Pavol Loffay
 *
 * Best =       N*log(N)
 * Average =    N*log(N)
 * Worst =      N*log(N)
 * Space comp = N, some implementations acheive N/2
 * Stable - alg. does NOT change position of elements with the same keys
 *
 * Sorting partialy sorted array requires the same time as unsorted array
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] arr) {

        LinkedList<T> sortedList = mergeSort(new LinkedList<>(Arrays.asList(arr)));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedList.get(i);
        }
    }

    private LinkedList<T> mergeSort(LinkedList<T> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int middle = arr.size() >> 1;
        LinkedList<T> left = new LinkedList<>(arr.subList(0, middle));
        LinkedList<T> right = new LinkedList<>(arr.subList(middle, arr.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private LinkedList<T> merge(LinkedList<T> left, LinkedList<T> right) {
        LinkedList<T> merged = new LinkedList<>();
        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.peekFirst().compareTo(right.peekFirst()) < 0) {
                merged.add(left.getFirst());
                left.removeFirst();
            } else if (left.peekFirst().compareTo(right.peekFirst()) == 0){
                merged.add(right.getFirst());
                merged.add(left.getFirst());
                right.removeFirst();
                left.removeFirst();
            } else {
                merged.add(right.getFirst());
                right.removeFirst();
            }
        }

        while (!left.isEmpty()) {
            merged.add(left.getFirst());
            left.removeFirst();
        }
        while (!right.isEmpty()) {
            merged.add(right.getFirst());
            right.removeFirst();
        }

        return merged;
    }
}
