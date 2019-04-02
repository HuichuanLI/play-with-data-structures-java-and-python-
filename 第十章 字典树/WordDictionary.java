// 211
import java.util.TreeMap;

class WordDictionary {

    private class Node {
        public boolean isWord;
        // 只是这里有问题
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this.isWord = false;
            next = new TreeMap<>();
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {

        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cut = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cut.next.get(c) == null) {
                cut.next.put(c, new Node());

            }
            cut = cut.next.get(c);
        }
        if (!cut.isWord) {
            cut.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root,word,0);
    }

    private  boolean match(Node node,String word,int index){

        if(index == word.length()){
            return  node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null){
                return  false;
            }
            return  match(node.next.get(c),word,index+1);
        }else{
            for(char charnext : node.next.keySet())
                if(match(node.next.get(charnext),word,index+1))
                    return true;
                return false;

        }
    }
}