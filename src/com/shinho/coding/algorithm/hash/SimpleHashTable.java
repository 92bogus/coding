package com.shinho.coding.algorithm.hash;

public class SimpleHashTable {
    int tableSize;
    SHTNode[] table;

    public SimpleHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new SHTNode[tableSize];
    }

    void set(int key, int value) {
        int address = hash(key, this.tableSize);
        SHTNode node = new SHTNode(key, value);
        this.table[address] = node;
    }

    private int hash(int key, int tableSize) {
        return key % tableSize;
    }

    int get(int key) {
        int address = hash(key, this.tableSize);

        return this.table[address].value;
    }
}
