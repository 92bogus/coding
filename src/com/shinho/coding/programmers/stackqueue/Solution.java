package com.shinho.coding.programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    /*private static class Job {
        int progress;

        public Job(int progress) {
            this.progress = progress;
        }

        public boolean isComplete() {
            return (this.progress >= 100);
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> queue = new LinkedList<>();
        Job[] todos = new Job[progresses.length];
        for (int i=0; i<progresses.length; i++) {
            todos[i] = new Job(progresses[i]);
            queue.add(todos[i]);
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int res = doWork(queue, todos, progresses, speeds);
            if (res != 0) {
                list.add(res);
            }
        }

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private int doWork(Queue<Job> queue, Job[] todos, int[] progresses, int[] speeds) {
        for (int i=0; i<progresses.length; i++) {
            todos[i].progress += speeds[i];
        }

        int completeJobCount = 0;
        Job currentJob = queue.peek();

        if (currentJob.isComplete()) {
            do {
                queue.poll();
                currentJob = queue.peek();
                completeJobCount++;
            } while (currentJob != null && currentJob.isComplete());
        }

        return completeJobCount;
    }*/

    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = 0;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
