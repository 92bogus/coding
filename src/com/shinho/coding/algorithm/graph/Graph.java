package com.shinho.coding.algorithm.graph;

import com.shinho.coding.algorithm.heap.PQNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 인접 리스트(Adjacency List)로 Graph 구현하기
 */
public class Graph {
    public static void main(String[] args) {
        Graph g = new Graph();
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");

        g.addVertex(A);
        g.addVertex(B);
        g.addVertex(C);
        g.addVertex(D);
        g.addVertex(E);
        g.addVertex(F);
        g.addVertex(H);
        g.addVertex(I);

        g.addEdge(A, new Edge(A, B, 35));
        g.addEdge(A, new Edge(A, E, 247));

        g.addEdge(B, new Edge(B, A, 35));
        g.addEdge(B, new Edge(B, C, 126));
        g.addEdge(B, new Edge(B, F, 150));

        g.addEdge(C, new Edge(C, B, 126));
        g.addEdge(C, new Edge(C, D, 117));
        g.addEdge(C, new Edge(C, F, 162));
        g.addEdge(C, new Edge(C, G, 220));

        g.addEdge(D, new Edge(D, C, 117));

        g.addEdge(E, new Edge(E, A, 247));
        g.addEdge(E, new Edge(E, F, 82));
        g.addEdge(E, new Edge(E, H, 98));

        g.addEdge(F, new Edge(F, B, 150));
        g.addEdge(F, new Edge(F, C, 162));
        g.addEdge(F, new Edge(F, E, 82));
        g.addEdge(F, new Edge(F, H, 120));

        g.addEdge(G, new Edge(G, C, 220));
        g.addEdge(G, new Edge(G, F, 154));
        g.addEdge(G, new Edge(G, I, 106));

        g.addEdge(H, new Edge(H, E, 98));
        g.addEdge(H, new Edge(H, F, 120));

        g.addEdge(I, new Edge(I, G, 106));

        g.printGraph();

        Graph mst = g.prim(A);
        mst.printGraph();
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

    Graph prim(Vertex startVertex) {
        Graph mst = new Graph();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight)); // 최솟값 우선순위
        int inf = 99999;

        // mst 초기화
        Vertex currentVertex = this.vertices;
        while (currentVertex != null) {
            Vertex newVertex = new Vertex(currentVertex.data);
            mst.addVertex(newVertex);
            currentVertex = currentVertex.next;
        }


        return mst;
    }
}
