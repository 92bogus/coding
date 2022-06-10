package com.shinho.coding.cote.sec01;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        int lt = 0, rt = str.length() - 1;
        char[] s = str.toCharArray();
        while (lt < rt) {
            if (isNotAlphabet(s[lt])) {
                lt++;
            } else if (isNotAlphabet(s[rt])) {
                rt--;
            } else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;
            }
        }

        answer = String.valueOf(s);
        return answer;
    }

    /*

        Character.isAlphabetic()
     */
    public static boolean isNotAlphabet(char target) {
        boolean answer = false;

        target = Character.toUpperCase(target);
        if (target < 65 || target > 90) {
            answer = true;
        }

        return answer;
    }
}
