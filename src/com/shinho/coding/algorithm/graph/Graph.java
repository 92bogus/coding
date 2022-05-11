package com.shinho.coding.algorithm.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 인접 리스트(Adjacency List)로 Graph 구현하기
 */
public class Graph {
    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);

        g.addEdge(v1, new Edge(v1, v2, 0));
        g.addEdge(v1, new Edge(v1, v3, 0));
        g.addEdge(v1, new Edge(v1, v4, 0));
        g.addEdge(v1, new Edge(v1, v5, 0));

        g.addEdge(v2, new Edge(v2, v1, 0));
        g.addEdge(v2, new Edge(v2, v3, 0));
        g.addEdge(v2, new Edge(v2, v5, 0));

        g.addEdge(v3, new Edge(v3, v1, 0));
        g.addEdge(v3, new Edge(v3, v2, 0));

        g.addEdge(v4, new Edge(v4, v1, 0));
        g.addEdge(v4, new Edge(v4, v5, 0));

        g.addEdge(v5, new Edge(v5, v1, 0));
        g.addEdge(v5, new Edge(v5, v2, 0));
        g.addEdge(v5, new Edge(v5, v4, 0));

        g.printGraph();
        System.out.println();
        //g.dfs(v1);
        System.out.println("@@");
        g.bfs(v1);
    }

    enum VisitMode {
        VISITED, NOT_VISITED
    }

    static class Vertex {
        Object data;
        VisitMode visited;
        int index;

        Vertex next;
        Edge adjacencyList;

        public Vertex(Object data) {
            this.data = data;
            this.next = null;
            this.adjacencyList = null;
            this.visited = VisitMode.NOT_VISITED;
            this.index = -1;
        }
    }

    static class Edge {
        Vertex from;
        Vertex target;
        int weight;
        Edge next;

        public Edge(Vertex from, Vertex target, int weight) {
            this.from = from;
            this.target = target;
            this.weight = weight;

            this.next = null;
        }
    }

    Vertex vertices;
    int vertexCount;

    public Graph() {
        this.vertexCount = 0;
    }

    void addVertex(Vertex v) {
        Vertex vertexList = this.vertices;
        if (vertexList == null)
            this.vertices = v;
        else {
            while (vertexList.next != null) {
                vertexList = vertexList.next;
            }

            vertexList.next = v;
        }

        v.index = this.vertexCount++;
    }

    void addEdge(Vertex v, Edge e) {
        if (v.adjacencyList == null)
            v.adjacencyList = e;
        else {
            Edge adjacencyList = v.adjacencyList;

            while (adjacencyList.next != null)
                adjacencyList = adjacencyList.next;

            adjacencyList.next = e;
        }
    }

    void printGraph() {
        Vertex v = null;
        Edge e = null;

        if((v = this.vertices) == null)
            return;

        while (v != null) {
            System.out.print(v.data + ": ");

            if ((e = v.adjacencyList) == null) {
                v = v.next;
                System.out.println();
                continue;
            }

            while (e != null) {
                System.out.print(e.target.data + "[" +  e.weight + "]");
                e = e.next;
            }

            System.out.println();

            v = v.next;
        }

        System.out.println();
    }

    /**
     * 인접 리스트(Adjacency List)로 구현한 그래프의 깊이 우선 탐색
     */
    void dfs(Vertex v) {
        Edge e = null;
        System.out.print(v.data + " ");

        v.visited = VisitMode.VISITED;

        e = v.adjacencyList;

        while (e != null) {
            if (e.target != null && e.target.visited == VisitMode.NOT_VISITED)
                dfs(e.target);

            e = e.next;
        }
    }

    /**
     * 인접 리스트(Adjacency List)로 구현한 그래프의 너비 우선 탐색
     */
    void bfs(Vertex v) {
        Edge e = null;
        Queue<Vertex> queue = new LinkedList<>();

        System.out.print(v.data + " ");
        v.visited = VisitMode.VISITED;

        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            e = v.adjacencyList;

            while (e != null) {
                v = e.target;
                if (v != null && v.visited == VisitMode.NOT_VISITED) {
                    System.out.print(v.data + " ");
                    v.visited = VisitMode.VISITED;
                    queue.add(v);
                }
                e = e.next;
            }
        }
    }
}
