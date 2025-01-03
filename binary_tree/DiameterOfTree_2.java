package binary_tree;

public class DiameterOfTree_2 {
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

    static class Info {
        int diameter;
        int length;

        public Info(int diameter, int length) {
            this.diameter = diameter;
            this.length = length;
        }
    }

    public static Info calculateDiameter(Node root) {
        if (root == null)
            return new Info(0, 0);
        Info leftDia = calculateDiameter(root.leftNode);
        Info rightDia = calculateDiameter(root.rightNode);
        int length = Math.max(leftDia.length, rightDia.length) + 1;
        int diameter = Math.max(Math.max(leftDia.diameter, rightDia.diameter), leftDia.length + rightDia.length + 1);
        return new Info(diameter, length);
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Diameter: " + calculateDiameter(root).diameter);
    }
}
