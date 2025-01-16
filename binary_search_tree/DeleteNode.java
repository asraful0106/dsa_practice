package binary_search_tree;

public class DeleteNode {
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
        if (val < root.data) {
            root.leftNode = insertInBST(root.leftNode, val);
        } else {
            root.rightNode = insertInBST(root.rightNode, val);
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

    public static Node findInOrderSuccessor(Node root) {
        while (root.leftNode != null) {
            root = root.leftNode;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (val > root.data) {
            root.rightNode = delete(root.rightNode, val);
        } else if (val < root.data) {
            root.leftNode = delete(root.leftNode, val);
        } else {
            // --------Case - 1 (leaf Node)------------
            if (root.leftNode == null && root.rightNode == null) {
                return null;
            }
            // -----case -2 (one child) -------
            if (root.leftNode == null) {
                return root.rightNode;
            } else if (root.rightNode == null) {
                return root.leftNode;
            }
            // ----------case -3 (two child) --------
            Node inOrderSuccessor = findInOrderSuccessor(root.rightNode);
            root.data = inOrderSuccessor.data;
            delete(root.rightNode, inOrderSuccessor.data);
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("Before Delete: ");
        printInOrder(root);
        System.out.println();
        delete(root, 6);
        System.out.println("After Delete: ");
        printInOrder(root);
        System.out.println();
    }
}
