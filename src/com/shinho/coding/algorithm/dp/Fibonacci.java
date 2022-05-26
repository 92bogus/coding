package com.shinho.coding.algorithm.dp;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        long res = f.fibonacci(40);
        //System.out.println(res);
        System.out.println(f.fibonacci2(50));
    }

    long fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    long fibonacci2(int n) {
        long result;
        long[] fibonacciTable;

        if (n == 0 || n == 1)
            return n;

        fibonacciTable = new long[n+1];
        fibonacciTable[0] = 0;
        fibonacciTable[1] = 1;

        for (int i=2; i<=n; i++) {
            fibonacciTable[i] = fibonacciTable[i-1] + fibonacciTable[i-2];
        }

        result = fibonacciTable[n];

        return result;
    }
}
