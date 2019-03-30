
public class LinkedList<E> {


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node(){
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private  Node head;
    int size;

    public LinkedList(){
        head = new Node(); // 虚拟头节点
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = this.head;
//        head = node;
//  没有虚拟头节点的情况
//        head = new Node(e,head);
//        size++;

        add(0,e);

    }

    public void add(int index ,E e){
        if(index <0 || index > size)
            throw  new IllegalArgumentException("out of range");
        Node a = head;
        for(int i=0;i<index;i++){
            a=a.next;
        }
        Node one = new Node(e,a.next);
        a.next =one;
        size++;
    }

    public void addlast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index <0 || index > size)
            throw  new IllegalArgumentException("out of range");

        Node cur = this.head.next;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        return  cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = head.next;
        for(int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = head.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    public E delete(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = head.next;
        for(int i = 0 ; i < index-1 ; i ++)
            cur = cur.next;
        Node result = cur.next;
        cur.next = result.next;
        size --;
        result.next = null;
        return  result.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return delete(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return delete(size - 1);
    }

    public void removeElement(E e){
        Node prev = head.next;
        while(prev!=null){
            if(prev.next.e.equals(e)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next !=null){
            Node delNode = prev.next;
            prev.next =delNode.next;
            delNode.next = null;
            size--;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = head.next ; cur != null ; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }






}
