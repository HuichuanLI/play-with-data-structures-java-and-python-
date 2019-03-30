
 class LinkedList<K, V> {


    private class Node {
        public K key;
        public V value;

        public Node next;

        public Node(K k, V v, Node next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }

        public Node(K key) {
            this.key = key;
            this.value = null;
            this.next = null;
        }


        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return " "+key.toString() + " : " + value.toString()+" ";
        }
    }

    private Node head;
    int size;

    public LinkedList() {
        head = new Node(); // 虚拟头节点
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(K key, V value) {
//        Node node = new Node(e);
//        node.next = this.head;
//        head = node;
//  没有虚拟头节点的情况
//        head = new Node(e,head);
//        size++;

        add(0, key, value);

    }

    public void add(int index, K k, V v) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("out of range");
        Node a = head;
        for (int i = 0; i < index; i++) {
            a = a.next;
        }
        Node one = new Node(k, v, a.next);
        a.next = one;
        size++;
    }

    public void addlast(K k, V v) {
        add(size, k, v);
    }

    private Node getNode(K key) {
        Node cur = head.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public boolean contains(K key) {
        return getNode(key) != null;
    }


    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    public void add(K key,V value){
        Node node =getNode(key);
        if(node==null){
            head.next = new Node(key,value,head.next);
            size++;
        }else{
            node.value = value;
        }
    }


    public void set(K k,V value){
        Node node = getNode(k);
        if(node ==null){
            throw  new IllegalArgumentException("key isn't exists!");
        }
        node.value = value;
    }

    public V remove(K k){
        Node cur = head;
        while(cur.next != null){
            if(cur.next.key.equals(k)){
                Node del = cur.next;
                cur.next = del.next;
                del.next = null;
                size--;
                return del.value;
            }
        }
        return null;
    }

    public V get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("out of range");

        Node cur = this.head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    // 获得链表的第一个元素
    public V getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public V getLast() {
        return get(size - 1);
    }

    public void set(int index, K key, V value) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = head.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.value = value;
    }


    public V delete(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = head.next;
        for (int i = 0; i < index - 1; i++)
            cur = cur.next;
        Node result = cur.next;
        cur.next = result.next;
        size--;
        result.next = null;
        return result.value;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public V removeFirst() {
        return delete(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public V removeLast() {
        return delete(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = head.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }


}
