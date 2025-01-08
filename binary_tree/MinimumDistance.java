package binary_tree;

public class MinimumDistance {
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

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;
        Node leftNode = lca(root.leftNode, n1, n2);
        Node rightNode = lca(root.rightNode, n1, n2);
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }

    public static int distance(Node root, int n) {
        if (root == null)
            return -1;
        if (root.data == n)
            return 0;
        int leftDistance = distance(root.leftNode, n);
        int rightDistance = distance(root.rightNode, n);
        if (leftDistance == -1 && rightDistance == -1) {
            return rightDistance + 1;
        } else if (leftDistance == -1) {
            return rightDistance + 1;
        } else {
            return leftDistance + 1;
        }
    }
    public static int minimumDistance(Node root, int n1, int n2){
        Node lca = lca(root, n1, n2);
        return distance(lca, n1) + distance(lca, n2);
    }
    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Minimum Distance: " + minimumDistance(root, 4, 5));
    }
}
