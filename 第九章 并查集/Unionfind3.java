public class Unionfind3 implements UF {

    private int[] parent;
    private int[] sz;

    public Unionfind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
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
        if (sz[pRoot] < sz[qRoot]){
            parent[pRoot] = qRoot;
            sz[qRoot]+= sz[pRoot];
         }else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }



    }
}
