package binary_search_tree;

import java.util.ArrayList;

public class ConvertBstToBlancedBST {
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

    public static void printPreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printPreOrder(root.leftNode);
        printPreOrder(root.rightNode);
    }

    public static void getSortedArr(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;
        getSortedArr(root.leftNode, arr);
        arr.add(root.data);
        getSortedArr(root.rightNode, arr);
    }

    public static Node getBlancedBST(ArrayList<Integer> sortedArr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(sortedArr.get(mid));
        root.leftNode = getBlancedBST(sortedArr, start, mid - 1);
        root.rightNode = getBlancedBST(sortedArr, mid + 1, end);
        return root;

    }

    public static Node convertToBlancedBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        getSortedArr(root, arr);
        return getBlancedBST(arr, 0, arr.size() - 1);
    }

    public static void main(String[] args) {
        int values[] = { 8, 6, 5, 3, 10, 11, 12 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("Unblanced BST pre-order: ");
        printPreOrder(root);
        System.out.println();
        root = convertToBlancedBST(root);
        System.out.println("Blanced BST pre-order: ");
        printPreOrder(root);
        System.out.println();
    }
}
