package binary_tree;

public class KthAncestor {
    static class Node{
        int data;
        Node leftNode;
        Node rightNode;
        public Node(int data){
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }
    static class BinaryTree{
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
    public static int kAncestor(Node root, int n, int k){
        if(root == null) return -1;
        if(root.data == n) return 0;
        int leftNode = kAncestor(root.leftNode, n, k);
        int rightNode = kAncestor(root.rightNode, leftNode, k);
        if(leftNode==-1 && rightNode == -1) return -1;
        int max = Math.max(leftNode, rightNode);
        if(max+1 == k){
            System.out.println("Kth Ancestor: "+root.data);
        }
        return max+1;
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        kAncestor(root, 4, 2);
    }
}
