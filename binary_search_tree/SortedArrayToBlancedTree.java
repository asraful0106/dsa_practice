package binary_search_tree;

public class SortedArrayToBlancedTree {
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

    public static void printInOrder(Node root) {
        if (root == null)
            return;
        printInOrder(root.leftNode);
        System.out.print(root.data + " ");
        printInOrder(root.rightNode);
    }

    public static Node sortedArrayToBalencedTree(int sortedArr[], int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node root = new Node(sortedArr[mid]);
        root.leftNode = sortedArrayToBalencedTree(sortedArr, start, mid - 1);
        root.rightNode = sortedArrayToBalencedTree(sortedArr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int sortedArr[] = { 3, 5, 6, 8, 10, 11, 14 };
        Node root = sortedArrayToBalencedTree(sortedArr, 0, sortedArr.length - 1);
        System.out.println("BST: ");
        printInOrder(root);
        System.out.println();
    }
}
