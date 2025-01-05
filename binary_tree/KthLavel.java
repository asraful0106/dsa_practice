package binary_tree;

public class KthLavel {
    static class Node{
        int data;
        Node leftNode = null;
        Node rightNode = null;
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
    public static void kthLavel(Node root, int lavel, int k){
        if(root == null) return;
        if(lavel == k){
            System.out.print(root.data+" ");
            return;
        }
        kthLavel(root.leftNode, lavel+1, k);
        kthLavel(root.rightNode, lavel+1, k);
    }
    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.idx = -1;
        Node root = tree.buildBinaryTree(node);
        kthLavel(root, 0, 2);
    }
}
