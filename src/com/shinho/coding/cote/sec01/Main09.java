package com.shinho.coding.cote.sec01;

import java.util.Scanner;

public class Main09 {
    public static /*String*/ int solution(String input) {
        // 내가 푼 방법
        /* String answer = "";

        char[] charArr = input.toCharArray();
        for (char c : charArr) {
            if (c >= 48 && c <= 57) {
                if (answer.length() == 0 && c == 48)
                    continue;

                answer += c;
            }
        }

        return answer;*/

        // 다른 방법1
        /*int answer = 0;
        for(char x : input.toCharArray()) {
            if (x>=48 && x <= 57) answer = answer * 10 + (x - 48);
        }*/

        // 다른 방법2
        String answer = "";
        for(char x : input.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }
}
