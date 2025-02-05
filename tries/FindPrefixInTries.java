package tries;

public class FindPrefixInTries {
    static class Node {
        Node[] childrens = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < childrens.length; i++) {
                childrens[i] = null;
                freq = 1;
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
            } else {
                curr.childrens[idx].freq++;
            }
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node tries, String ans) {
        if (tries == null) {
            return;
        }
        if (tries.freq == 1) {
            System.out.print(ans + " ");
            return;
        }
        for (int level = 0; level < tries.childrens.length; level++) {
            if (tries.childrens[level] != null) {
                findPrefix(tries.childrens[level], ans + (char) (level + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "zebra", "dog", "duck", "dove" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
        System.out.println();
    }
}
