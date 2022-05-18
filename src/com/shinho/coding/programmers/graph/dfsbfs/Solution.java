package com.shinho.coding.programmers.graph.dfsbfs;

public class Solution {
    int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return this.count;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == 0)
            this.count = 0;

        if (depth == numbers.length) {
            if (sum == target)
                this.count++;

            return;
        }

        dfs(numbers, target, depth + 1, sum - numbers[depth]);
        dfs(numbers, target, depth + 1, sum + numbers[depth]);

    }
}
