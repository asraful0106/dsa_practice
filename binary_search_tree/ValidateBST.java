package binary_search_tree;

import java.util.ArrayList;

public class ValidateBST {
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

    public static boolean isValidBST(Node root, Node max, Node min) {
        if (root == null)
            return true;
        if (max != null && root.data >= max.data) {
            return false;
        } else if (min != null && root.data <= min.data) {
            return false;
        }
        return isValidBST(root.leftNode, root, null) && isValidBST(root.rightNode, null, root);
    }

    public static void main(String[] args) {
        // int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        int values[] = { 8, 5, 1, 1, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("Is Valid BST or not: ");
        System.out.println();
        if (isValidBST(root, null, null)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Invalid BST");
        }
    }
}
