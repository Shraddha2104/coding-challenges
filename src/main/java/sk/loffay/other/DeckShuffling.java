package sk.loffay.other;

import java.util.Random;

/**
 * @author Pavol Loffay
 */
public class DeckShuffling {

    /**
     * Randomly reorder items in the array (uniformly distributed)
     */
    public static <T> void shuffle(T arr[]) {

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            int swapIndex = random.nextInt(arr.length - i);
            swap(arr, i, i + swapIndex);
        }
    }

    private static <T> void swap(T arr[], int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
