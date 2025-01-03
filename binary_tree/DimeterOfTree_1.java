package binary_tree;

public class DimeterOfTree_1 {
    static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data) {
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

    public static int hieghtOftree(Node root) {
        if (root == null)
            return 0;

        int leftHeight = hieghtOftree(root.leftNode);
        int rightHeight = hieghtOftree(root.rightNode);
        return leftHeight + rightHeight + 1;
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;

        int leftDia = diameter(root.leftNode);
        int leftH = hieghtOftree(root.leftNode);
        int rightDia = diameter(root.rightNode);
        int rightH = hieghtOftree(root.rightNode);

        int selfDiameter = leftH + rightH + 1;

        return Math.max(selfDiameter, Math.max(leftDia, rightDia));
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);

        System.out.println("The Diameter of the tree is: "+diameter(root));
    }
}
