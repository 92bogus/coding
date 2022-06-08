package com.shinho.coding.cote.sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    4. 단어 뒤집기
    설명

    N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


    입력
    첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

    두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


    출력
    N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


    예시 입력 1

    3
    good
    Time
    Big
    예시 출력 1

    doog
    emiT
    giB
 */
public class Main04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i<n; i++) {
            arr[i] = sc.next();
        }

        for (String x : solution(n, arr)) {
            System.out.println(x);
        }

    }

    public static List<String> solution(int n, String[] arr) {
        List<String> answer = new ArrayList<>();
        for (String s : arr) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

}
