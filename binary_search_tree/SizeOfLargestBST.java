package binary_search_tree;

public class SizeOfLargestBST {
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

    static class Info {
        boolean isTree;
        int size;
        int max;
        int min;
        Node root;

        public Info(boolean isTree, int size, int max, int min, Node root) {
            this.isTree = isTree;
            this.size = size;
            this.max = max;
            this.min = min;
            this.root = root;
        }
    }

    public static int largestBSTsize = 0;
    public static Node largestBST = null;

    public static Info findLargestBST(Node root) {
        // Base Case
        if (root == null)
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, null);

        Info leftTree = findLargestBST(root.leftNode);
        Info rightTree = findLargestBST(root.rightNode);

        int size = leftTree.size + rightTree.size + 1;
        int max = Math.max(root.data, Math.max(leftTree.max, rightTree.max));
        int min = Math.min(root.data, Math.min(leftTree.min, rightTree.min));

        Node newRoot = new Node(root.data);
        newRoot.leftNode = leftTree.root;
        newRoot.rightNode = rightTree.root;

        if (root.data <= leftTree.max || root.data >= rightTree.min)
            return new Info(false, size, max, min, newRoot);

        if (leftTree.isTree && rightTree.isTree) {
            largestBSTsize = Math.max(largestBSTsize, size);
            largestBST = newRoot;
            return new Info(true, size, max, min, newRoot);
        }
        return new Info(false, size, max, min, newRoot);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.leftNode = new Node(30);
        root.leftNode.leftNode = new Node(5);
        root.leftNode.rightNode = new Node(20);

        root.rightNode = new Node(60);
        root.rightNode.leftNode = new Node(45);
        root.rightNode.rightNode = new Node(70);
        root.rightNode.rightNode.leftNode = new Node(65);
        root.rightNode.rightNode.rightNode = new Node(80);

        System.out.println("Created BST: ");
        printPreOrder(root);
        System.out.println();
        findLargestBST(root);
        System.out.println("Largest size of the valid BST: " + largestBSTsize);
        System.out.println("Largest valid BST: ");
        printPreOrder(largestBST);
        System.out.println();
    }
}
