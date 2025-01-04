package binary_tree;

public class SubTreeOfAnotherTree {
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
        public Node buildBinaryTree(int node[], boolean isNewTree){
            if(isNewTree) idx = -1;
            idx++;
            if(node[idx] == -1) return null;

            Node newNode = new Node(node[idx]);
            newNode.leftNode = buildBinaryTree(node, false);
            newNode.rightNode = buildBinaryTree(node, false);
            return newNode;
        }
    }
    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data) return false;

        if(!isIdentical(node.leftNode, subRoot.leftNode)) return false;
        if(!isIdentical(node.rightNode, subRoot.rightNode)) return false;
        
        return true;
    }
    public static boolean isSubTree(Node root, Node subRoot){
        if(root == null) return false;
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)) return true;
        }
        return isSubTree(root.leftNode, subRoot) || isSubTree(root.rightNode, subRoot);
    }
    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(node, false);
        int subNode[] = {2, 4, -1, -1, 5, -1, -1};
        Node subRoot = tree.buildBinaryTree(subNode, true);
        System.out.println("isSubtree: "+ isSubTree(root, subRoot));
    }
} 
