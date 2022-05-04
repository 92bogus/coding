package com.shinho.coding.algorithm.heap;

import java.util.Arrays;

public class PriorityQueue {
    int capacity;
    int usedSize;
    PQNode[] nodes;

    PriorityQueue(int initialSize) {
        this.capacity = initialSize;
        this.usedSize = 0;
        this.nodes = new PQNode[initialSize];
    }

    void enqueue(PQNode newData) {
        int currentPosition = this.usedSize;
        int parentPosition = getParent(currentPosition);

        /* 용량이 꽉 찼을때 */
        if (this.usedSize == this.capacity) {
            if (this.capacity == 0) this.capacity = 1;
            this.capacity *= 2;
            this.nodes = Arrays.copyOf(this.nodes, this.capacity);
        }

        this.nodes[currentPosition] = newData;

        /* 후속 처리 */
        while (currentPosition > 0 && this.nodes[currentPosition].priority > this.nodes[parentPosition].priority) {
            swapNodes(currentPosition, parentPosition);

            currentPosition = parentPosition;
            parentPosition = getParent(currentPosition);
        }

        this.usedSize++;
    }

    private void swapNodes(int index1, int index2) {
        PQNode temp = this.nodes[index1];
        this.nodes[index1] = this.nodes[index2];
        this.nodes[index2] = temp;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    PQNode dequeue() {
        // STEP1. 가장 깊은 레벨의 최우측노드를 루트로 옮기기
        int parentPosition = 0;
        int leftPosition = 0;
        int rightPosition = 0;

        PQNode root = this.nodes[0];
        this.nodes[0] = null;
        this.usedSize--;
        swapNodes(0, this.usedSize);

        leftPosition = getLeftChild(0);
        rightPosition = leftPosition + 1;

        while (true) {
            // STEP2. 루트의 자식 중 우선순위가 높은 자식 선택
            int selectedChild = 0;
            if (leftPosition >= usedSize)
                break;
            // 왼쪽 자식만 있는 경우
            if (rightPosition >= this.usedSize)
                selectedChild = leftPosition;
            else {
                // 자식이 둘 다 있으면 크기 비교
                // 자식 중 우선순위가 높은걸 선택
                if (this.nodes[leftPosition].priority < this.nodes[rightPosition].priority)
                    selectedChild = rightPosition;
                else
                    selectedChild = leftPosition;
            }

            // STEP3. 선택된 자식과 부모 중 우선순위 비교하여 자식이 우선순위가 높다면 위치를 맞바꾼다
            if (this.nodes[selectedChild].priority > this.nodes[parentPosition].priority) {
                swapNodes(selectedChild, parentPosition);
                parentPosition = selectedChild;
            } else
                break;

            leftPosition = getLeftChild(parentPosition);
            rightPosition = leftPosition + 1;
        }

        if (this.usedSize < this.capacity / 2) {
            this.capacity /= 2;
            this.nodes = Arrays.copyOf(this.nodes, this.capacity);
        }

        return root;
    }

    private int getLeftChild(int parent) {
        return 2 * parent + 1;
    }

    boolean isEmpty() {
        return this.usedSize == 0 ? true : false;
    }

}
