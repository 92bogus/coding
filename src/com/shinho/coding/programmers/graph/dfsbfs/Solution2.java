package com.shinho.coding.programmers.graph.dfsbfs;

public class Solution2 {
    enum VisitMode {
        VISITED, NOT_VISITED
    }
    static class Graph {
        Vertex vertices;
        int vertexCount;

        public Graph() {
            this.vertexCount = 0;
        }

        void addVertex(Vertex v) {
            if (this.vertices == null)
                this.vertices = v;
            else {
                Vertex currentVertex = this.vertices;
                while (currentVertex.next != null) {
                    currentVertex = currentVertex.next;
                }
                currentVertex.next = v;
                v.index = this.vertexCount++;
            }
        }

        void addEdge(Vertex v, Edge e) {
            if (v.adjacencyList == null)
                v.adjacencyList = e;
            else {
                Edge currentEdge = v.adjacencyList;
                while (currentEdge.next != null) {
                    currentEdge = currentEdge.next;
                }
                currentEdge.next = e;
            }

        }
    }
    static class Vertex {
        Object data;
        Edge adjacencyList;
        VisitMode visited;
        Vertex next;
        int index;

        public Vertex(Object data) {
            this.data = data;
            this.adjacencyList = null;
            this.visited = VisitMode.NOT_VISITED;
            this.next = null;
            this.index = -1;
        }
    }

    static class Edge {
        Vertex target;
        int weight;
        Edge next;

        public Edge(Vertex target) {
            this.target = target;
            this.weight = 1;
            this.next = null;
        }
    }

    public int solution(int n, int[][] computers) {
        Vertex[] vertexList = new Vertex[n];
        Graph g = new Graph();

        for (int i=0; i<n; i++) {
            Vertex newVertex = new Vertex(i);
            vertexList[i] = newVertex;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j && computers[i][j] == 1) {
                    g.addEdge(vertexList[i], new Edge(vertexList[j]));
                }
            }
        }

        for (Vertex vertex : vertexList) {
            dfs(vertex);
        }
    }

    private void dfs(Vertex v) {
        System.out.println(v.data);
        v.visited = VisitMode.VISITED;

        Edge e = v.adjacencyList;
        while (e != null) {
            Vertex targetVertex = e.target;
            if (targetVertex != null && targetVertex.visited == VisitMode.NOT_VISITED ) {
                dfs(targetVertex);
            }
            e = e.next;
        }

    }
}
