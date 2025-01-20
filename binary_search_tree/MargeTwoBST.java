package binary_search_tree;

import java.util.ArrayList;

public class MargeTwoBST {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
            this.leftNode = this.rightNode = null;
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

    public static Node createBlancedBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.leftNode = createBlancedBST(arr, start, mid - 1);
        root.rightNode = createBlancedBST(arr, mid + 1, end);
        return root;
    }

    public static Node margeBST(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getSortedArr(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        getSortedArr(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }
        return createBlancedBST(finalArr, 0, finalArr.size() - 1);
    }

    public static void main(String[] args) {
        int values1[] = {2, 1, 4};
        Node root1 = null;
        for(int i = 0; i<values1.length; i++){
            root1 = insertInBST(root1, values1[i]);
        }
        int values2[] = { 9, 3, 12};
        Node root2 = null;
        for (int i = 0; i < values1.length; i++) {
            root2 = insertInBST(root2, values2[i]);
        }
        System.out.println("BST1: ");
        printPreOrder(root1);
        System.out.println();
        System.out.println("BST2: ");
        printPreOrder(root2);
        System.out.println();
        System.out.println("Marged BST: ");
        Node margedBST = margeBST(root1, root2);
        printPreOrder(margedBST);
        System.out.println();
    }
}
