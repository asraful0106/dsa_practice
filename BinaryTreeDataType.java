import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDataType {
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

    public static void preOrder(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        // root
        System.out.print(root.data + " ");
        // left sub-tree
        preOrder(root.leftNode);
        // right sub-tree
        preOrder(root.rightNode);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        // ----left-subtree
        inOrder(root.leftNode);
        // -----root
        System.out.print(root.data + " ");
        // -----Right subtree
        inOrder(root.rightNode);
    }

    public static void postOrder(Node root){
            if(root == null) return;
            // left sub-tree
            postOrder(root.leftNode);
            // right sub-tree
            postOrder(root.rightNode);
            // root
            System.out.print(root.data+" ");
        }
    
    public static void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node cureentNode = q.remove();
            if(cureentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(cureentNode.data+" ");
                if(cureentNode.leftNode != null) q.add(cureentNode.leftNode);
                if(cureentNode.rightNode != null) q.add(cureentNode.rightNode);
            }
        }

    }
    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);

        levelOrder(root);
    }
}
