package sk.loffay.other;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**

  Doubly linked list:
     node      node    node     node
     +---+    +---+    +---+    +---+    +---+    +---+
     | x |<-->| x |<-->| x |<-->|   |<-->| x |<-->|   |
     +---+    +---+    +---+    +---+    +---+    +---+  ⇒ 2
      ^         ^        ^                 ^
      |         |        |                 |
      +         +        +                 +
     [-----------------------]           [-----]
           1st block                    2nd block

    +---+    +---+    +---+    +---+    +---+    +---+
    | x |<-->|   |<-->| x |<-->|   |<-->| x |<-->|   |
    +---+    +---+    +---+    +---+    +---+    +---+  ⇒ 3

 Write a function that takes list of nodes from doubly linked list and returns number of blocks.

 *
 * @author Pavol Loffay
 */
public class NumberOfBlocks {

    /**
     * O(N) time
     */
    public static int  numberOfBlocks(List<ListNode> nodes) {
        if (nodes == null) {
            throw new IllegalArgumentException();
        }

        Set<ListNode> nodeSet = new HashSet<>(nodes);
        int blocks = 0;

        for (ListNode current: nodes) {
            if (!nodeSet.contains(current)) {
                continue;
            }

            blocks++;
            nodeSet.remove(current);

            ListNode node = current.getRight();
            while(node != null) {
                if (!nodeSet.contains(node)) {
                    break;
                }

                nodeSet.remove(node);
                node = node.getRight();
            }

            node = current.getLeft();
            while(node != null) {
                if (!nodeSet.contains(node)) {
                    break;
                }

                nodeSet.remove(node);
                node = node.getLeft();
            }
        }

        return blocks;
    }

    public static class ListNode {
        private ListNode left;
        private ListNode right;

        public ListNode getLeft() {
            return left;
        }

        public ListNode getRight() {
            return right;
        }
    }
}
