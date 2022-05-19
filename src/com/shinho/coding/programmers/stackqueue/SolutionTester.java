package com.shinho.coding.programmers.stackqueue;

public class SolutionTester {
    public static void main(String[] args) {
        int[] progresses = new int[] { 93, 30, 55 };
        int[] speeds = new int[] { 1, 30, 5 };

        Solution sol = new Solution();
        printArray(sol.solution(progresses, speeds));
    }

    static void printArray(int[] result) {
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
