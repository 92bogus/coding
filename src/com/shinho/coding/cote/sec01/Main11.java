package com.shinho.coding.cote.sec01;

import java.util.Scanner;

public class Main11 {
    public static String solution(String input) {
        // 내가 푼거
       /* String answer = "";
        char[] charArr = (input + "\0").toCharArray();

        for (int i=0; i<charArr.length; i++) {
            char current = charArr[i];
            if (current == '\0') {
                break;
            }
            int cnt = 1;

            while (charArr[i+1] == current) {
                cnt++;
                i++;
            }

            if (cnt == 1) {
                answer = answer + current;
            } else {
                answer = answer + current + cnt;
            }

        }
        return answer;*/
        String answer = "";
        input = input + " ";
        int cnt = 1;
        for (int i=0; i<input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                cnt++;
            } else {
                answer += input.charAt(i);
                if (cnt > 1) {
                    answer += cnt;
                    cnt = 1;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(solution(str));

        sc.close();
    }


}
