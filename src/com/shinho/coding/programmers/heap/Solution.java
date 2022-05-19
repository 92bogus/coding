package com.shinho.coding.programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int [] scoville, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;
        try {
            do {
                count++;
            } while(!mix(queue, k));

        } catch (Exception e) {
            return -1;
        }


        return count;
    }

    private boolean mix(PriorityQueue<Integer> queue, int k) {
        if (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();

            queue.add(a + 2 * b);
        } else if (queue.peek() < k) {
            throw new RuntimeException();
        }

        if (queue.peek() >= k)
            return true;
        else
            return false;

    }

}
