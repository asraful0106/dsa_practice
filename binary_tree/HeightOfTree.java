package binary_tree;

public class HeightOfTree {
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

    public static int caluclateNodeHeight(Node root){
        if(root == null) return 0;
        int left = caluclateNodeHeight(root.leftNode);
        int right = caluclateNodeHeight(root.rightNode);
        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        int node[] = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Height of the Binary tree: "+caluclateNodeHeight(root));
    }
}
