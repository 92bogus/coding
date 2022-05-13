package com.shinho.coding.algorithm.hash;

public class SimpleHashTableTester {
    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable(193);

        ht.set(418, 32114);
        ht.set(9, 514);
        ht.set(27, 8917);
        ht.set(1031, 286);

        System.out.println("Key: " + 418 + ", Value: " + ht.get(418));
        System.out.println("Key: " + 9 + ", Value: " + ht.get(9));
        System.out.println("Key: " + 27 + ", Value: " + ht.get(27));
        System.out.println("Key: " + 1031 + ", Value: " + ht.get(1031));
    }
}
