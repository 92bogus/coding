package com.shinho.coding.algorithm.heap;

public class PriorityQueueTester {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(3);
        queue.enqueue(createNode("오버워치", 10));
        queue.enqueue(createNode("메이플", 8));
        queue.enqueue(createNode("운동", 20));
        queue.enqueue(createNode("코딩", 999));
        queue.enqueue(createNode("이닦기", 888));
        queue.enqueue(createNode("출근", 777));

        System.out.println("큐에 있는 작업 수: " + queue.usedSize);

        while (!queue.isEmpty()) {
            PQNode popped = queue.dequeue();
            printNode(popped);
        }
    }

    static PQNode createNode(Object data, int priority) {
        return new PQNode(data, priority);
    }

    static void printNode(PQNode node) {
        System.out.println("작업명: " + node.data);
        System.out.println("우선순위: " + node.priority);
    }
}
