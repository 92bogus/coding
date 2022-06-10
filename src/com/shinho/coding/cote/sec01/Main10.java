package com.shinho.coding.cote.sec01;

import java.util.Scanner;

public class Main10 {
    public static /*String*/int[] solution(String s, char c) {
        // 내가 푼 방식
//        String answer = "";
//        char[] charArr = s.toCharArray();
//
//        for (int i=0; i<charArr.length; i++) {
//            int idx = 0;
//            int min = Integer.MAX_VALUE;
//
//            if (charArr[i] == c) {
//                answer += "0 ";
//                continue;
//            }
//
//            for (int j=0; j<charArr.length; j++) {
//                if (charArr[j] == c) {
//                    int tmp = i - j > 0 ? i - j : j - i;
//                    if (min > tmp) {
//                        idx = j;
//                        min = tmp;
//                    }
//                }
//            }
//
//            answer += (min + " ");
//        }
//
//        return answer;
        
        // 다른 풀이
        int[] answer = new int[s.length()];
        int d = 1000;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                d = 0;
            } else {
                d++;
            }
            answer[i] = d;
        }

        d = 1000;
        for (int i=s.length() - 1; i>=0; i--) {
            if (s.charAt(i) == c) {
                d = 0;
            } else {
                d++;
                if (Math.min(answer[i], d) == d)
                    answer[i] = d;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);

        //System.out.println(solution(s, c));
        for(int x : solution(s, c)) {
            System.out.print(x + " ");
        }

        sc.close();
    }

}
