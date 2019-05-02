
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
        root = add(root, e);
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
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);

        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }


    // 前序遍历
    public void preOrder() {
        System.out.println("preorder");
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.println("inOrder");
        inOrder(root);
    }
    // 中序遍历 就是排序

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder() {
        System.out.println("postOrder");
        postOrder(root);
    }
    // 中序遍历 就是排序

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 实用stack 非递归的遍历
    public void preOrder2() {
        System.out.println("preorder");
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    // 层序遍历 使用queue
    public void levelOrder() {
        System.out.println("levelorder");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    // min
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("size is 0");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left != null) {
            return minimum(node.left);
        } else {
            return node;
        }
    }

    // max
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("size is 0");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right != null) {
            return maximum(node.right);
        } else {
            return node;
        }
    }

    // delete min and max

    public E removeMin() {
        Node ret = minimum(root);

        root = removeMin(root);
        return ret.e;
    }

    // delete min
    // 每次 返回 删掉左子树的节点
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node cur = node.right;
            node.right = null;
            size--;
            return cur;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        Node ret = maximum(root);
        root = removeMax(root);
        return ret.e;
    }

    // delete max
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node cur = node.left;
            node.left = null;
            size--;
            return cur;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }
    // 这个 分了三次情况
    // 1。 有有右子树
    //2。有左子树
    //找右子树 最小的
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightnode = node.right;
                node.right = null;
                size--;
                return rightnode;
            }
            if (node.right == null) {
                Node leftnode = node.left;
                node.left = null;
                size--;
                return leftnode;
            }
            Node cur = minimum(node.right);
            cur.right = removeMin(node.right);
            cur.left = node.left;
            node.left = node.right = null;
            return cur;
        }
    }
}