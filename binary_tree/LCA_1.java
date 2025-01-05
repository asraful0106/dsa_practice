package binary_tree;

import java.util.ArrayList;

// Lowest Common Ancestor_Aprroch1
public class LCA_1 {
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
    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root == null) return false;

        path.add(root);
        
        if(root.data == n) return true;

        if(getPath(root.leftNode, n, path)||getPath(root.rightNode, n, path)) return true;

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for(; i<path1.size()&&i<path2.size(); i++){
            if(path1.get(i).data != path2.get(i).data) break;
        }
        return path1.get(i-1);
    }
    public static void main(String[] args) {
        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node);
        System.out.println("Lowest Common Ancestor: "+lca(root, 4, 7).data);
    }
}
