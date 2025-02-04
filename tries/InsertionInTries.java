package tries;

public class InsertionInTries {
    public static class Node {
        Node[] childrens = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                this.childrens[i] = null;
            }
        }
    }

    // Initilized the Empty Node for the bigning
    static Node root = new Node();

    public static void insert(String wrod) {
        Node curr = root;
        for (int level = 0; level < wrod.length(); level++) {
            int idx = wrod.charAt(level) - 'a';
            if (curr.childrens[idx] == null)
                curr.childrens[idx] = new Node();
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    public static void main(String[] args) {
        String[] words = { "the", "a", "their", "there", "any", "thee" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
    }
}
