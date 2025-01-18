package binary_search_tree;

import java.util.ArrayList;

public class PrintRootToLeaf {
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

    public static Node insertInBST(Node root, int val) {
        if (root == null)
            return new Node(val);
        if (val > root.data) {
            root.rightNode = insertInBST(root.rightNode, val);
        } else {
            root.leftNode = insertInBST(root.leftNode, val);
        }
        return root;
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("null");
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null)
            return;
        path.add(root.data);
        if (root.leftNode == null && root.rightNode == null)
            printPath(path);
        printRootToLeaf(root.leftNode, path);
        printRootToLeaf(root.rightNode, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("Root to Leaf paths: ");
        System.out.println();
        printRootToLeaf(root, new ArrayList<>());
    }
}
