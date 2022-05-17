package com.shinho.coding.datastructure.tree.disjointset;

public class DisjointSet {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        DisjointSet set1 = new DisjointSet(a);
        DisjointSet set2 = new DisjointSet(b);
        DisjointSet set3 = new DisjointSet(c);
        DisjointSet set4 = new DisjointSet(d);

        System.out.println((set1.findRoot() == set2.findRoot()));
        set1.unionSet(set3);
        set3.unionSet(set4);

        System.out.println(set1.findRoot() == set3.findRoot());
        System.out.println(set3.findRoot() == set4.findRoot());
    }

    DisjointSet parent;
    Object data;

    public DisjointSet(Object data) {
        this.data = data;
        this.parent = null;
    }

    public void unionSet(DisjointSet node) {
        node = node.findRoot();
        node.parent = this;
    }

    public DisjointSet findRoot() {
        DisjointSet root = this;

        while (root.parent != null) {
            root = root.parent;
        }

        return root;

    }
}
