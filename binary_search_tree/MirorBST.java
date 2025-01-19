package binary_search_tree;

public class MirorBST {
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
    public static Node insertInBST(Node root, int val){
        if(root == null) return new Node(val);
        if(val>root.data){
            root.rightNode = insertInBST(root.rightNode, val);
        }else{
            root.leftNode = insertInBST(root.leftNode, val);
        }
        return root;
    }
    public static void printInOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        printInOrder(root.leftNode);
        printInOrder(root.rightNode);
    }
    public static Node mirrorBST(Node root){
        if(root == null) return null;
        Node leftMirror = mirrorBST(root.leftNode);
        Node rightMirror = mirrorBST(root.rightNode);
        root.leftNode = rightMirror;
        root.rightNode = leftMirror;
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        System.out.println("BST: ");
        printInOrder(root);
        System.out.println();
        root = mirrorBST(root);
        System.out.println("Mirror BST: ");
        printInOrder(root);
        System.out.println();
    }
}
