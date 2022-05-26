package com.shinho.coding.algorithm.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MakingChange {
    static void getChange(int price, int pay, int coinUnits[], int change[], int size) {
        int changeAmount = pay - price;

        for (int i=0; i<size; i++) {
            change[i] = countCoins(changeAmount, coinUnits[i]);
            changeAmount = changeAmount - (coinUnits[i] * change[i]);
        }
    }

    static int countCoins(int amount, int coinUnit) {
        int coinCount = 0;
        int currentAmount = amount;

        while (currentAmount >= coinUnit) {
            coinCount++;
            currentAmount = currentAmount - coinUnit;
        }

        return coinCount;
    }

    public static void main(String[] args) {
        int pay = 0;
        int price = 0;
        int unitCount = 0;
        int[] coinUnits = null;
        int[] change = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("동전의 가짓수? ");
        unitCount = sc.nextInt();

        coinUnits = new int[unitCount];
        change = new int[unitCount];

        for (int i=0; i<unitCount; i++) {
            System.out.print(i + "번째 동전의 단위를 입력: ");
            coinUnits[i] = sc.nextInt();
        }

        Arrays.sort(Arrays.stream(coinUnits).mapToObj(o -> o).toArray(), Collections.reverseOrder());

        System.out.print("물건의 가격: ");
        price = sc.nextInt();

        System.out.print("손님이 지불한 돈은 얼마? ");
        pay = sc.nextInt();

        getChange(price, pay, coinUnits, change, unitCount);
        printChange(coinUnits, change, unitCount);
    }
    
    static void printChange(int[] coinUnits, int change[], int size) {
        for (int i=0; i<size; i++) {
            System.out.print(coinUnits[i] + "원: " + change[i] + "개");
        }
    }
}
