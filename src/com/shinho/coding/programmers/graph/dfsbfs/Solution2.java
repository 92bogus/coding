package com.shinho.coding.programmers.graph.dfsbfs;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static class DisjointSet {
        DisjointSet parent;
        Object data;

        public DisjointSet(Object data) {
            this.data = data;
            this.parent = null;
        }

        DisjointSet findParent() {
            if (this.parent == null)
                return this;

            DisjointSet root = this.parent;
            while (root.parent != null) {
                root = root.parent;
            }

            return root;
        }

        void union(DisjointSet target) {
            DisjointSet px = findParent();
            DisjointSet py = target.findParent();

            if (px != py)
                py.parent = px;
        }
    }

    public int solution(int n, int[][] computers) {
        DisjointSet[] coms = new DisjointSet[n];
        for (int i=0; i<n; i++) {
            coms[i] = new DisjointSet(i);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    coms[i].union(coms[j]);
                }
            }
        }

        int count = 0;
        for (int i=0; i<n; i++) {
            if (coms[i].parent == null)
                count++;
        }

        return count;
    }
}
