import java.util.TreeMap;

// 677
class MapSum {


    private class Node {
        public boolean isWord;
        // 只是这里有问题
        public TreeMap<Character, Node> next;
        int value;

        public Node(boolean isWord,int value ) {
            this.isWord = isWord;
            next = new TreeMap<>();
            this.value = value;
        }

        public Node(int value) {
            this.isWord = false;
            next = new TreeMap<>();
            this.value = value;
        }

        public Node() {
            this.isWord = false;
            next = new TreeMap<>();
            this.value = 0;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cut = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cut.next.get(c) == null) {
                    cut.next.put(c, new Node());
            }
            cut = cut.next.get(c);
        }
       cut.value = val;
    }

    public int sum(String prefix) {
        Node cut = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cut.next.get(c) == null){
                return 0;
            }
            cut = cut.next.get(c);
        }
        int sum = 0;
        return sum(cut);
    }

    private  int sum(Node node){
        int res =0;
        if(node == null){
            return 0;
        }
        res = node.value;
        for(char charnext : node.next.keySet()){
            res +=  sum(node.next.get(charnext));
        }
        return res;
    }


}
