package com.shinho.coding.programmers.graph;

public class GraphTester {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result =
        sol.solution(6, new int[][] {
                { 3, 6 },
                { 4, 3 },
                { 3, 2 },
                { 1, 3 },
                { 1, 2 },
                { 2, 4 },
                { 5, 2 }
        });

        System.out.println(result);
    }
}
