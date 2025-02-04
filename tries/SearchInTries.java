package tries;

public class SearchInTries {
    static class Node{
        Node[] childrens = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++){
                this.childrens[i] = null;
            }
        }
    }

    // Initilized the root
    static Node root = new Node();

    // Funtion for the insertion in the tries
    public static void insert(String word){
        Node curr = root;
        for(int level = 0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.childrens[idx] == null)
                curr.childrens[idx] = new Node();
            curr = curr.childrens[idx];
        }
        curr.eow = true;
    }

    // Function for finding the key in the tries
    public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level<key.length(); level++){
            int idx = key.charAt(level)-'a';
            if(curr.childrens[idx] == null)
                return false;
            curr = curr.childrens[idx];
        }
        return curr.eow == true;
    }
    public static void main(String[] args) {
        String[] words = {"the", "a", "their", "there", "any", "thee"};
        for(int i = 0; i<words.length; i++){
            insert(words[i]);
        }

        System.out.println(search("there"));
        System.out.println(search("anyone"));
    }
}
