import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// binary search tree
// 1. 没有重复 元素 其实 也可以 相等
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(E e) {
       root = add(root,e);
    }
    // version 1
//    private void add(Node node, E e) {
//        if (node.e.equals(e)) {
//            return;
//        } else if (node.e.compareTo(e) < 0) {
//            if (node.right != null) {
//                add(node.right, e);
//            } else {
//                node.right = new Node(e);
//                size++;
//                return;
//            }
//        } else {
//            if (node.left != null) {
//                add(node.left, e);
//            } else {
//                node.left = new Node(e);
//                size++;
//            }
//        }
//    }
    //version 2
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);

        }
        else if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) >0){
            node.right = add(node.right,e);
        }
        return node;
    }

    public boolean contains(E e){
        return  contains(root,e);
    }

    private boolean contains(Node node, E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if(e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }


    // 前序遍历
    public void preOrder(){
        System.out.println("preorder");
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        System.out.println("inOrder");
        inOrder(root);
    }
    // 中序遍历 就是排序

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder(){
        System.out.println("postOrder");
        postOrder(root);
    }
    // 中序遍历 就是排序

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 实用stack 非递归的遍历
    public  void preOrder2(){
        System.out.println("preorder");
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    // 层序遍历 使用queue
    public  void levelOrder(){
        System.out.println("levelorder");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
    }
}
