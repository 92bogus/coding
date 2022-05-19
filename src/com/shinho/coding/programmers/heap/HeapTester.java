package com.shinho.coding.programmers.heap;

public class HeapTester {
    public static void main(String[] args) {
        int[] scoville = new int[] { 1, 2, 3, 9, 10, 12 };
        int k = 7;

        Solution sol = new Solution();
        System.out.println(sol.solution(scoville, k));
    }
}
