package com.shinho.coding.test;

import com.shinho.coding.algorithm.heap.PQNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Tester {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 10, 4, 5, 1, 9};
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }

    static void printArray(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
