package tries;

public class WordBreakProblem {
    static class Node {
        Node[] childrens = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                this.childrens[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.childrens[idx] == null)
                curr.childrens[idx] = new Node();
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.childrens[idx] == null)
                return false;
            curr = curr.childrens[idx];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0)
            return true;

        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = { "i", "love", "sam", "samsung", "mobile", "phone" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilovesamsung";
        String key1 = "ilovemobiledevice";

        System.out.println(wordBreak(key));
        System.out.println(wordBreak(key1));
    }

}
