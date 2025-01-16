package binary_search_tree;

public class SearchInBST {
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
        printInOrder(root.leftNode);
        System.out.print(root.data+" ");
        printInOrder(root.rightNode);
    }
    public static boolean search(Node root, int key){
        if(root == null)return false;
        if(root.data == key) return true;
        if(root.data>key){
            return search(root.leftNode, key);
        }else{
            return search(root.rightNode, key);
        }
    }
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertInBST(root, values[i]);
        }
        printInOrder(root);
        System.out.println();
        if(search(root, 6)){
            System.out.println("Key is found!");
        }else{
            System.out.println("Key is not found!");
        }
    }
}
