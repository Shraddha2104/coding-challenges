package sk.loffay.artin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavol on 18.1.2015.
 */
public class Tree {

    public static class Node {
        int value;
        List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public void addChildren(Node node) {
            children.add(node);
        }
    }

    /**
     * Uloha 3
     *
     * Implementujte funkciu, ktora spocita hodnotu uzlov s strome do urcitej hlbky
     *
     * @param root koren stromu
     * @param depth hlbka do ktorej sa ma pocitat
     * @return suma hodnot v uzloch
     */
    public static int valuesSum(Node root, int depth) {

        int sum = root.value;

        if (depth == 0) {
            return sum;
        }


        for (Node node: root.children) {
            sum += valuesSum(node, depth - 1);
        }

        return sum;
    }
}
