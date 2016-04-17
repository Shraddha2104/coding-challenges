package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavol Loffay
 *
 * 100 %
 * 51.951
 * mem: 8110080
 */
public class LowestCommonAncestor {

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        Node root = init();

        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] split = line.split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            Node lowestAncestor = lowestCommonAncestor(root, x, y);
            System.out.println(lowestAncestor.value);
        }
    }

    public static Node lowestCommonAncestor(Node node, int x, int y) {

        if (x > node.getValue() && y > node.getValue()) {
            return lowestCommonAncestor(node.right, x, y);
        } else if (x < node.getValue() && y < node.getValue()) {
            return lowestCommonAncestor(node.left, x, y);
        }

        return node;
    }

    public static Node init() {
        return new Node(30, new Node(8, new Node(3), new Node(20, new Node(10), new Node(29))), new Node(52));
    }

    public static class Node {
        private int value;

        private Node left;
        private Node right;

        public Node(int value) {
            this(value, null, null);
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }
    }
}
