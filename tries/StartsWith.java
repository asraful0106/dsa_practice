package tries;

public class StartsWith {
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

    public static boolean startsWith(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childrens[idx] == null)
                return false;
            curr = curr.childrens[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "apple", "app", "mango", "man", "woman" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(startsWith("app"));
        System.out.println(startsWith("moon"));
    }
}
