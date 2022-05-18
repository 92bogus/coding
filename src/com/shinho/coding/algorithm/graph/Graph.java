package com.shinho.coding.algorithm.graph;

import com.shinho.coding.datastructure.tree.disjointset.DisjointSet;

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
        g.addVertex(G);
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
        g.addEdge(F, new Edge(F, G, 82));
        g.addEdge(F, new Edge(F, H, 120));

        g.addEdge(G, new Edge(G, C, 220));
        g.addEdge(G, new Edge(G, F, 154));
        g.addEdge(G, new Edge(G, I, 106));

        g.addEdge(H, new Edge(H, E, 98));
        g.addEdge(H, new Edge(H, F, 120));

        g.addEdge(I, new Edge(I, G, 106));

        System.out.println("----------------- 원본 그래프---------------");
        g.printGraph();

        //Graph mst = g.prim(A);
        Graph mst = g.kruskal();
        System.out.println("-----------------최소 신장 트리(크루스칼 알고리즘)-----------------");
        mst.printGraph();

        Graph dag = new Graph();
        Vertex AA = new Vertex('A');
        Vertex BB = new Vertex('B');
        Vertex CC = new Vertex('C');
        Vertex DD = new Vertex('D');
        Vertex EE = new Vertex('E');
        Vertex FF = new Vertex('F');
        Vertex GG = new Vertex('G');
        Vertex HH = new Vertex('H');
        Vertex II = new Vertex('I');

        dag.addVertex(AA);
        dag.addVertex(BB);
        dag.addVertex(CC);
        dag.addVertex(DD);
        dag.addVertex(EE);
        dag.addVertex(FF);
        dag.addVertex(GG);
        dag.addVertex(HH);
        dag.addVertex(II);

        dag.addEdge(AA, new Edge(AA, EE, 247));

        dag.addEdge(BB, new Edge(BB, AA, 35));
        dag.addEdge(BB, new Edge(BB, CC, 126));
        dag.addEdge(BB, new Edge(BB, FF, 150));

        dag.addEdge(CC, new Edge(CC, DD, 117));
        dag.addEdge(CC, new Edge(CC, FF, 162));
        dag.addEdge(CC, new Edge(CC, GG, 220));

        dag.addEdge(EE, new Edge(EE, HH, 98));

        dag.addEdge(FF, new Edge(FF, EE, 82));
        dag.addEdge(FF, new Edge(FF, GG, 154));
        dag.addEdge(FF, new Edge(FF, HH, 120));

        dag.addEdge(GG, new Edge(GG, II, 106));

        System.out.println("-----------------DAG----------------");
        dag.printGraph();
        Graph shortestPath = dag.dijkstra(BB);
        System.out.println("------------------shortestPath(dijkstra)----------------");
        shortestPath.printGraph();
    }

    enum VisitMode {
        VISITED, NOT_VISITED
    }

    public static class Vertex {
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
        return null;
    }

    Graph kruskal() {
        Graph mst = new Graph();    // 반환 할 최소 신장 트리
        Vertex[] mstVertices = new Vertex[this.vertexCount];    // mst의 정점들을 모아둘 배열

        DisjointSet[] vertexSet = new DisjointSet[this.vertexCount];    // 원본 그래프의 정점 분리 집합

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight)); // 간선을 오름차순으로 정렬하여 순차 탐색하기 위한 우선순위 큐

        Vertex currentVertex = null;

        int i = 0;

        // step.1 모든 간선 오름차순 정렬하기 및 초기화
        currentVertex = this.vertices;

        while (currentVertex != null) {
            vertexSet[i] = new DisjointSet(currentVertex);  // 원본 정점의 분리 집합 생성

            Vertex mstVertex = new Vertex(currentVertex.data);
            mst.addVertex(mstVertex);  // 원본 정점을 복사하여 mst에 추가
            mstVertices[i] = mstVertex; // 배열 형태도로 저장

            Edge currentEdge = currentVertex.adjacencyList;

            while (currentEdge != null) {
                queue.add(currentEdge);
                currentEdge = currentEdge.next;
            }

            currentVertex = currentVertex.next;
            i++;
        }

        // step.2 정렬한 간선 순서대로 각각 from, to 정점이 분리 집합 관계일 경우, mst에 해당 간선을 추가한다.
        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            int fromIndex = currentEdge.from.index;
            int toIndex = currentEdge.target.index;

            if (vertexSet[fromIndex].findRoot() != vertexSet[toIndex].findRoot()) {
                mst.addEdge(mstVertices[fromIndex], new Edge(mstVertices[fromIndex], mstVertices[toIndex], currentEdge.weight));
                mst.addEdge(mstVertices[toIndex], new Edge(mstVertices[toIndex], mstVertices[fromIndex], currentEdge.weight));

                vertexSet[fromIndex].unionSet(vertexSet[toIndex]);
            }
        }

        return mst;
    }

    Graph dijkstra(Vertex startVertex) {
        Graph shortestPath = new Graph();
        Vertex[] shortestPathVertices = new Vertex[this.vertexCount];   // 최단 경로 그래프의 정점 배열

        Vertex[] fringes = new Vertex[this.vertexCount];                // 이미 지난 경로인지 확인?
        Vertex[] precedences = new Vertex[this.vertexCount];            // 해당 인덱스에 해당해는 정점의 이 전 우선순위 경로 ex) precedences[0]이 C다 -> 0번 인덱스에 해당하는
                                                                        // 정점은 A 이므로 A는 이전 경로로 C를 통하여 방문한다
        int[] weights = new int[this.vertexCount];                      // 시작 정점부터 타겟 정점까지의 최단 경로 길이(가중치 합)

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        Vertex currentVertex = this.vertices;

        int i = 0;
        int MAX_WEIGHT = 99999;

        // step.1 초기화: 리턴할 최단 경로 그래프에 정점 추가
        while (currentVertex != null) {
            Vertex newVertex = new Vertex(currentVertex.data);
            shortestPath.addVertex(newVertex);
            shortestPathVertices[i] = newVertex;

            fringes[i] = null;
            precedences[i] = null;
            weights[i] = MAX_WEIGHT;

            currentVertex = currentVertex.next;
            i++;
        }

        queue.add(new Edge(startVertex, startVertex, 0));
        weights[startVertex.index] = 0; // 자기 자신의 거리는 0

        while (!queue.isEmpty()) {
            Edge popped = queue.poll();
            currentVertex = (Vertex) popped.target;

            fringes[currentVertex.index] = currentVertex;

            Edge currentEdge = currentVertex.adjacencyList;
            while (currentEdge != null) {
                Vertex targetVertex = currentEdge.target;
                // 지나온 경로가 아니고 && 이전 정점까지의 거리와 타겟 정점까지의 간선의 거리 합이 타겟 정점까지의 거리 합 보다 작은 경우, 타겟 정점까지의 거리 합 UPDATE
                if (fringes[targetVertex.index] == null && weights[currentVertex.index] + currentEdge.weight < weights[targetVertex.index]) {
                    queue.add(currentEdge);
                    precedences[targetVertex.index] = currentEdge.from;
                    weights[targetVertex.index] = weights[currentVertex.index] + currentEdge.weight;
                }

                currentEdge = currentEdge.next;
            }
        }

        for (i=0; i<this.vertexCount; i++) {
            int fromIndex, toIndex;

            if (precedences[i] == null)
                continue;

            fromIndex = precedences[i].index;
            toIndex = i;

            shortestPath.addEdge(
                    shortestPathVertices[fromIndex],
                    new Edge(shortestPathVertices[fromIndex], shortestPathVertices[toIndex], weights[i]));
        }

        System.out.print("precedences: ");
        for (i=0; i<this.vertexCount; i++) {
            if (precedences[i] != null)
                System.out.print(precedences[i].data + " ");
            else
                System.out.print("null ");
        }

        System.out.println();

        return shortestPath;
    }
}
