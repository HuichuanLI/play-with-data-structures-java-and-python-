public class RedBlackTree <K extends Comparable<K>,V>{
    private  static  final  boolean RED = true;
    private  static final  boolean Black = false;
    private  class Node{
        public  K key;
        public V value;
        public Node left,right;
        public boolean color;


        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private  Node root;
    private  int size;

    public RedBlackTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return  size == 0;
    }

    private  boolean isRed(Node node){
        if(node == null)
            return Black;
        return node.color;

    }
}
