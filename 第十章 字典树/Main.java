public class Main {
    public static  void main(String [] args){

        String a = "catcat";
        Trie trie = new Trie();
        trie.add(a);
        System.out.println(trie.contains("cat"));

    }
}
