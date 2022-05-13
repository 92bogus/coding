package com.shinho.coding.algorithm.graph;

import java.util.LinkedList;

public class TopologicalSortGraph extends Graph {
    public static void main(String[] args) {
        TopologicalSortGraph graph = new TopologicalSortGraph();

        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');
        Vertex G = new Vertex('G');
        Vertex H = new Vertex('H');

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        graph.addVertex(E);
        graph.addVertex(F);
        graph.addVertex(G);
        graph.addVertex(H);

        graph.addEdge(A, new Edge(A, C, 0));
        graph.addEdge(A, new Edge(A, D, 0));

        graph.addEdge(B, new Edge(B, C, 0));
        graph.addEdge(B, new Edge(B, E, 0));

        graph.addEdge(C, new Edge(C, F, 0));

        graph.addEdge(D, new Edge(D, F, 0));
        graph.addEdge(D, new Edge(D, G, 0));

        graph.addEdge(E, new Edge(E, G, 0));

        graph.addEdge(F, new Edge(F, H, 0));

        graph.addEdge(G, new Edge(G, H, 0));

        System.out.print("Visit Result: ");
        graph.topologicalSort(A);

        System.out.println();
        System.out.print("Topological Sort Result: ");

        for (Vertex v : graph.list) {
            System.out.print(v.data + " ");
        }

    }

    LinkedList<Vertex> list;

    void topologicalSort(Vertex v) {
        while (v != null && v.visited == VisitMode.NOT_VISITED) {
            dfs(v);

            v = v.next;
        }
    }

    @Override
    void dfs(Vertex v) {
        if (this.list == null)
            list = new LinkedList<>();

        System.out.print(v.data + " ");

        v.visited = VisitMode.VISITED;

        Edge e = v.adjacencyList;

        while (e != null) {
            if (e.target != null && e.target.visited == VisitMode.NOT_VISITED) {
                dfs(e.target);
            }

            e = e.next;
        }

        this.list.addFirst(v);
    }
}
