package heaps;

public class LongestWordPrifix {
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

    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childrens[idx] == null) {
                return false;
            }
            curr = curr.childrens[idx];
        }
        return curr.eow;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null)
            return;

        for (int i = 0; i < 26; i++) {
            if (root.childrens[i] != null && root.childrens[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length())
                    ans = temp.toString();
                longestWord(root.childrens[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "a", "bannana", "ap", "app", "appl", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
