package com.daniel.datastructures.union_find;

public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank; //  rank[i] is the height of the tree whose root is i;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
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
        if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        } else if(rank[qRoot] > rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // find group / index of p.
    private int find(int p) {
        if ( p < 0 || p > parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        //while (p != parent[p]) {
        //    parent[p] = parent[parent[p]];
        //    p = parent[p];
        //}
        if( p != parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

}