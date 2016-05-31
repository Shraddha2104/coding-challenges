package sk.loffay.sort;

/**
 * @author Pavol Loffay
 */
public interface Sort<T extends Comparable<T>> {
    void sort(T[] arr);
}
