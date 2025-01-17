package binary_search_tree;

public class PrintInRange {
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

    public static void printInOrder(Node root) {
        if (root == null)
            return;
        printInOrder(root.leftNode);
        System.out.print(root.data + " ");
        printInOrder(root.rightNode);
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null)
            return;
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.leftNode, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.rightNode, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.leftNode, k1, k2);
        } else {
            printInRange(root.rightNode, k1, k2);
        }
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("BST: ");
        printInOrder(root);
        System.out.println();
        System.out.println("BST in Range: ");
        printInRange(root, 5, 12);
        System.out.println();
    }
}
