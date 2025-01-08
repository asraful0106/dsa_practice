package binary_tree;

public class LCA_2 {
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

    public static Node lca_2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;
        Node leftNode = lca_2(root.leftNode, n1, n2);
        Node rightNode = lca_2(root.rightNode, n1, n2);
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Lowest Common Ancestor: " + lca_2(root, 4, 5).data);
    }
}
