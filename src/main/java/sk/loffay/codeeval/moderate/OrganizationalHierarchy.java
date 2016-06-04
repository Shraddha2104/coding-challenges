package sk.loffay.codeeval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Pavol Loffay
 *
 * 100%
 */
public class OrganizationalHierarchy {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;

        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            Node root = null;

            String[] split = line.split("\\|");
            for (String bossAndDumb: split) {
                bossAndDumb = bossAndDumb.trim();

                String boss = "" + bossAndDumb.charAt(0);
                String worker = "" + bossAndDumb.charAt(1);

                if (root == null) {
                    root = new Node(boss);
                    root.subordinates.add(new Node(worker));
                } else if (!add(root, boss, worker) && worker.equals(root.name)) {
                    Node previousRoot = root;
                    root = new Node(boss);
                    root.subordinates.add(previousRoot);
                }
            }

            //print
            StringBuilder stringBuilder = new StringBuilder();
            printNonRecursive(root, stringBuilder);
            System.out.println(stringBuilder.toString().trim());
        }
    }

    private static void printRecursive(Node node, StringBuilder stringBuilder) {
        if (node != null) {
            stringBuilder.append(node.name);

            if (!node.subordinates.isEmpty()) {
                stringBuilder.append(" [");
            }
            Iterator<Node> nodeIterator = node.subordinates.iterator();
            while (nodeIterator.hasNext()) {
                Node subordinate = nodeIterator.next();
                printRecursive(subordinate, stringBuilder);
                if (nodeIterator.hasNext()) {
                    stringBuilder.append(", ");
                }
            }
            if (!node.subordinates.isEmpty()) {
                stringBuilder.append("]");
            }
        }
    }

    private static void printNonRecursive(Node node, StringBuilder stringBuilder) {

        LinkedList<LinkedList<Node>> stack = new LinkedList<>();
        LinkedList<Node> initRootList = new LinkedList<>();
        initRootList.push(node);
        stack.push(initRootList);

        while (!stack.isEmpty()) {
            node = getNode(stack);

            if (node != null) {
                stringBuilder.append(node.name);
                if (node.subordinates.isEmpty() && stack.peek() != null && !stack.peek().isEmpty()) {
                    stringBuilder.append(", ");
                } else if (!node.subordinates.isEmpty()) {
                    stringBuilder.append(" ");
                }

                if (node.subordinates.size() > 0) {
                    stringBuilder.append("[");
                    stack.push(new LinkedList<>(node.subordinates));
                }
            }

            if (stack.peek() != null && stack.peek().isEmpty()) {
                stack.pop();
                //skip last one
                if (stack.size() > 0) {
                    stringBuilder.append("]");
                    if (stack.peek().size() > 0) {
                        stringBuilder.append(", ");
                    }
                }
            }
        }
    }

    private static Node getNode(LinkedList<LinkedList<Node>> stack) {
        LinkedList<Node> subStack = stack.peek();
        Node node =  subStack != null && subStack.peek() != null ? subStack.pop() : null;
        return node;
    }

    private static class Node {
        private final String name;
        private final Set<Node> subordinates = new TreeSet<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.name.compareTo(node2.name);
            }
        });

        public Node(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return name != null ? name.equals(node.name) : node.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

    private static boolean add(Node node, String boss, String worker) {

        if (node.name.equals(boss)) {
            node.subordinates.add(new Node(worker));
            return true;
        }

        for (Node subordinate: node.subordinates) {
            boolean added = add(subordinate, boss, worker);
            if (added) {
                return true;
            }
        }

        return false;
    }
}
