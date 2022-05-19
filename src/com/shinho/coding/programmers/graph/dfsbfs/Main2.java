package com.shinho.coding.programmers.graph.dfsbfs;

import org.w3c.dom.ls.LSOutput;

public class Main2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n = 6;
        int[][] computers = new int[][] {
                { 1, 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1 }
        };

        System.out.println(sol.solution(n, computers));
    }
}
