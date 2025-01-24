package org.sorts;

import java.util.Random;

public class MergeSort {

    private int[] randomNums(int capacity) {
        int[] arr = new int[capacity];
        Random rand = new Random();
        for (int i = 0; i < capacity; i++) {
            arr[i] = rand.nextInt(capacity);
        }
        return arr;
    }

    private void printArr(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }

    public static void main(String[] args) {
        MergeSort main = new MergeSort();
        int[] arr = main.randomNums(15);
        System.out.println("Before Sort\n");
        main.printArr(arr);
        System.out.println("\nAfter Sort\n");
        main.mergeSort(arr);
        main.printArr(arr);
    }

    private int[] mergeSort(int[] numArr) {
        int len = numArr.length;
        if (len < 2) return numArr;

        int midPoint = len / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[len - midPoint];

        for (int i = 0; i < midPoint; i++) leftArray[i] = numArr[i];
        for (int i = midPoint; i < len; i++) rightArray[i - midPoint] = numArr[i];

        mergeSort(leftArray);
        mergeSort(rightArray);

        return merge(leftArray, rightArray, numArr);
    }

    private int[] merge(int[] leftArray, int[] rightArray, int[] numArr){
        int leftCounter = 0, rightCounter = 0, ogCounter = 0;
        int leftSize = leftArray.length, rightSize = rightArray.length;
        int len = numArr.length;

        while (leftCounter < leftSize && rightCounter < rightSize) {
            if (leftArray[leftCounter] <= rightArray[rightCounter]){
                numArr[ogCounter] = leftArray[leftCounter++];
            } else numArr[ogCounter] = rightArray[rightCounter++];
            ogCounter++;
        }

        while (leftCounter < leftSize) {
            numArr[ogCounter++] = leftArray[leftCounter++];
        }

        while (rightCounter < rightSize) {
            numArr[ogCounter++] = rightArray[rightCounter++];
        }

        return numArr;
    }
}
