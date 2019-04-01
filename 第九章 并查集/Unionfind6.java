public class Unionfind6 implements UF {

    private int[] parent;
    private int[] rank;

    public Unionfind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 这个真的牛逼
    // 全部的都是一层的
    // 是递归的
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        if (p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    // o(h)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // o(h)
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        // 少的元素 指向多的 高度不变
        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;

        }else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }else{

            parent[qRoot] = pRoot;
            // 现在 不是 depth
            rank[pRoot] ++;

        }



    }
}
