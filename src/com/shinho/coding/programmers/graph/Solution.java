package com.shinho.coding.programmers.graph;

import java.util.*;

public class Solution {
    static class Edge {

        int from;
        int target;
        int weight;

        public Edge(int from, int target) {
            this.from = from;
            this.target = target;
            this.weight = 1;
        }
    }

    static List<Edge>[] adj;
    static boolean[] check;
    static int[] dist;

    public int solution(int n, int[][] edge) {
        adj = new ArrayList[n+1];
        check = new boolean[n+1];
        dist = new int[n+1];
        for (int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] ints : edge) {
            int start = ints[0];
            int end = ints[1];
            adj[start].add(new Edge(start, end));
            adj[end].add(new Edge(end, start));
        }

        dijkstra(1);

        int max = Arrays.stream(dist)
                .filter(val -> val != Integer.MAX_VALUE)
                .max()
                .orElse(Integer.MIN_VALUE);

        return (int) Arrays.stream(dist)
                .filter(val -> val == max)
                .count();
    }

    private void dijkstra(int first) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Arrays.fill(dist, Integer.MAX_VALUE);
        queue.add(new Edge(first, first));
        dist[first] = 0;

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int currentVertex = edge.target;

            check[currentVertex] = true;
            List<Edge> currentEdgeList = adj[currentVertex];
            for (Edge currentEdge : currentEdgeList) {
                if (!check[currentEdge.target] && dist[currentEdge.target] > dist[currentEdge.from] + currentEdge.weight) {
                    queue.add(currentEdge);
                    dist[currentEdge.target] = dist[currentEdge.from] + currentEdge.weight;
                }
            }
        }
    }
}