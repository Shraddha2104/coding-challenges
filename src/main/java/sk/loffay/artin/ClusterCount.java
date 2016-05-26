package sk.loffay.artin;

/**
 * Created by pavol on 18.1.2015.
 */
public class ClusterCount {

    /**
     * Uloha 2
     *
     * Implementujte funkciu, ktora spocita pocet zhlukov v poli.
     * Zhluku sa sa rozumie po sebe iduce cisla oddelene jednou alebo viacej nulami.
     *
     * [0,1,6,0,1,5,0] - ma 2 zhluky
     *
     * @param array
     * @return pocet zhlukov v poli
     */
    public static int clusterCount(int[] array) {

        int clusterCount = 0;
        boolean inCluster = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && inCluster) {
                inCluster = false;
            } else {
                if (!inCluster) {
                    clusterCount++;
                }
                inCluster = true;
            }
        }

        return clusterCount;
    }
}
