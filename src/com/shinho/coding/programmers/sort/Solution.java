package com.shinho.coding.programmers.sort;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int commandsLength = commands.length;
        for (int i=0; i<commandsLength; i++) {
            answer[i] = getValue(array.clone(), commands[i][0], commands[i][1], commands[i][2]);
        }
        return answer;
    }

    private int getValue(int[] array, int i, int j, int k) {
        rangeSpecifiedBubbleSort(array, i, j);
        return selectNthValueFromArray(array, i, k);
    }

    private void rangeSpecifiedBubbleSort(int[] array, int start, int end) {
        start -= 1;
        end -= 1;

        int length = end - start + 1;

        for (int i = 0; i<length - 1; i++) {
            for (int j=start; j<end-i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private int selectNthValueFromArray(int[] array, int start, int n) {
        start--;
        int targetIndex = start + n - 1;
        return array[targetIndex];
    }

}
