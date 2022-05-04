package com.shinho.coding.algorithm.heap;

public class PQNode {
    Object data;
    int priority;

    public PQNode(Object data, int priority) {
        this.data = data;
        this.priority = priority;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
