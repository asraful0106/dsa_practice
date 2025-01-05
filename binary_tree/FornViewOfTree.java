package binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FornViewOfTree {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    static class BinaryTree {
        static int idx;

        public Node buildBinaryTree(int node[]) {
            idx++;
            if (node[idx] == -1)
                return null;
            Node newNode = new Node(node[idx]);
            newNode.leftNode = buildBinaryTree(node);
            newNode.rightNode = buildBinaryTree(node);
            return newNode;
        }
    }

    static class Info {
        Node node;
        int horizontalDistance;

        public Info(Node node, int horizontalDistance) {
            this.node = node;
            this.horizontalDistance = horizontalDistance;
        }
    }

    public static void topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();

        q.add(new Info(root, 0));
        q.add(null);

        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty())
                    break;
                q.add(null);
            } else {
                if (!hm.containsKey(curr.horizontalDistance))
                    hm.put(curr.horizontalDistance, curr.node);
                if (curr.node.leftNode != null) {
                    q.add(new Info(curr.node.leftNode, curr.horizontalDistance - 1));
                    min = Math.min(min, curr.horizontalDistance - 1);
                }
                if (curr.node.rightNode != null) {
                    q.add(new Info(curr.node.rightNode, curr.horizontalDistance + 1));
                    max = Math.max(max, curr.horizontalDistance + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(hm.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        BinaryTree.idx = -1;
        Node root = tree.buildBinaryTree(node);
        topView(root);
    }
}
