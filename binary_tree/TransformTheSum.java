package binary_tree;

public class TransformTheSum {
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
        static int idx = -1;

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

    public static void printlr(Node root) {
        if (root == null) {
            System.out.print("-1" + " ");
            return;
        }
        System.out.print(root.data + " ");
        printlr(root.leftNode);
        printlr(root.rightNode);
    }

    public static int transformTheSum(Node root) {
        if (root == null)
            return 0;
        int leftChild = transformTheSum(root.leftNode);
        int rightChild = transformTheSum(root.rightNode);
        int currentLeft = root.leftNode == null ? 0 : root.leftNode.data;
        int currentRight = root.rightNode == null ? 0 : root.leftNode.data;
        int data = root.data;
        root.data = currentLeft+leftChild+currentRight+rightChild;
        return data;
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        printlr(root);
        System.out.println();
        transformTheSum(root);
        printlr(root);
    }
}
