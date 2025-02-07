package tries;

public class UniqueSubString {
    static class Node {
        Node[] childrens = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < childrens.length; i++) {
                childrens[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childrens[idx] == null) {
                curr.childrens[idx] = new Node();
            }
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    public static int countNode(Node root) {
        if (root == null)
            return 0;

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.childrens[i] != null)
                count += countNode(root.childrens[i]);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "apple";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println("Total unique substring: " + countNode(root));
    }
}
