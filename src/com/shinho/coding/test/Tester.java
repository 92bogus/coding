package com.shinho.coding.test;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 5, 2, 6, 3, 7, 4 };
        //Arrays.sort(array);

        printArray(array);

        printArray(Arrays.copyOfRange(array, 1, 5));

        printArray(array);
    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
