package binary_tree;

public class SumOfNodes {
    static class Node{
        int data;
        Node leftNode;
        Node rightNode;

        Node(int data){
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
    static class BinaryTre{
        static int idx = -1;
        public Node buildBinaryTree(int node[]){
            idx++;
            if(node[idx] == -1) return null;

            Node newNode = new Node(node[idx]);
            newNode.leftNode = buildBinaryTree(node);
            newNode.rightNode = buildBinaryTree(node);
            return newNode;
        }
    }
    public static int sumOfNodes(Node root){
        if(root == null) return 0;

        int leftNodeCount = sumOfNodes(root.leftNode);
        int rightNodeCount = sumOfNodes(root.rightNode);
        return leftNodeCount+rightNodeCount+root.data;
    }
    public static void main(String[] args) {
        int node[] = { 1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1 };
        BinaryTre tree = new BinaryTre();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Sum of node: " + sumOfNodes(root));
    }
}
