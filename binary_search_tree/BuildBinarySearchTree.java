package binary_search_tree;

public class BuildBinarySearchTree {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public static Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value > root.data) {
            root.rightNode = insert(root.rightNode, value);
        } else {
            root.leftNode = insert(root.leftNode, value);
        }
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null)
            return;
        printInorder(root.leftNode);
        System.out.print(root.data + " ");
        printInorder(root.rightNode);
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        printInorder(root);
        System.out.println();
    }
}
