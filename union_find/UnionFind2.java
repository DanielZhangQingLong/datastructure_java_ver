package com.daniel.datastructures.union_find;

public class UnionFind2 implements UF {

   private int[] parent;

   /* Once intialized, each self is a root;
    */
   public UnionFind2(int size) {
       parent = new int[size];
       for (int i = 0; i < size; i ++)
           parent[i] = i;
   }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        parent[pRoot] = qRoot;

    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // find group / index of p.
    private int find(int p) {
       if ( p < 0 || p > parent.length)
           throw new IllegalArgumentException("Index is invalid.");
       while (p != parent[p])
           p = parent[p];
       return p;
    }

}
