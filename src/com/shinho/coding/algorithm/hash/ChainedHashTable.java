package com.shinho.coding.algorithm.hash;

public class ChainedHashTable {
    int tableSize;
    CHTNode[] table;

    public ChainedHashTable(int tableSize) {
        this.tableSize = tableSize;
        this.table = new CHTNode[tableSize];
    }

    String get(String key) {
        int address = hash(key, this.tableSize);
        CHTNode list = this.table[address];
        CHTNode target = null;

        if (list == null)
            return null;

        while (true) { // 원하는 값을 찾을 때까지 순차 탐색
            if (list.key.equals(key)) {
                target = list;
                break;
            }

            if (list.next == null)
                return null;
            else
                list = list.next;
        }

        return target.value;
    }

    int hash(String key, int tableSize) {
        int hashValue = 0;
        for (int i=0; i<key.length(); i++) {
            hashValue = (hashValue << 3) + key.charAt(i);
        }

        hashValue = hashValue % tableSize;

        return hashValue;
    }
}
