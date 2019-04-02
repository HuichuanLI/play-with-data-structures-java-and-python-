import java.util.TreeMap;

public class Trie {

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
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // trie 添加 新的word
    public void add(String word) {
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
            this.size++;
        }
    }

    // 非递归
    //search
    public boolean contains(String word) {
        Node cut = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cut.next.get(c) == null) {
                return false;
            }
            cut = cut.next.get(c);
        }
        if (cut.isWord) {
            return true;
        } else {
            return false;
        }
    }

    public boolean prefix(String prefix){
        Node cur = root;
        for(int i =0 ; i< prefix.length();i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return  false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }



}
