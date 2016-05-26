package sk.loffay.artin;

/**
 * Created by pavol on 18.1.2015.
 */
public class FindMinInArray {

    /**
     * Uloha 1
     *
     * Implementujte funkciu, ktora vrati minimalny prvok v poli.
     * Minimalnym prvkom sa rozumie prvok, ktoreho hodnota je najblizsie hodnote 0.
     * Ak je v poli aj zaporna hodnota prvku, za mensiu povazujte kladnu.
     *
     * [9,9,7,0,1,-1] - Funkcia vrati 1.
     *
     * @param array
     * @return cislo ktoreho hodnota je najblizsia nule
     */
    public static int findMinInArray(int[] array) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && Math.abs(array[i]) <= Math.abs(min)) {
                if (!(Math.abs(array[i]) == Math.abs(min) && array[i] < min)) {
                    min = array[i];
                }
            }
        }

        return min;
    }
}
