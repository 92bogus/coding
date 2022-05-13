package com.shinho.coding.test;

import com.shinho.coding.algorithm.heap.PQNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Tester {

    public static void main(String[] args) {
        List<PQNode> list = new ArrayList<>();
        list.add(new PQNode("공부", 3));
        list.add(new PQNode("코딩", 2));
        list.add(new PQNode("게임", 4));
        list.add(new PQNode("취업", 1));

        list.sort((o1, o2) -> o1.getPriority() - o2.getPriority());

        for (PQNode pqNode : list) {
            System.out.println(pqNode.getData());
        }
    }

}
