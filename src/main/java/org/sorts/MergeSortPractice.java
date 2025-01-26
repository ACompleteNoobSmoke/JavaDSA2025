package org.sorts;

public class MergeSortPractice {

    public <T extends Comparable<T>> MergeSortPractice (T[] obj) {
        sort (obj);
    }

    private <T extends Comparable<T>> void sort(T[] obj) {
        int len = obj.length;
        if (len < 2) return;

        int midIndex = len / 2;
        T[] leftArr = (T[]) new Comparable[midIndex];
        T[] rightArr = (T[]) new Comparable[len - midIndex];

        for (int i = 0; i < midIndex; i++) leftArr[i] = obj[i];
        for (int j = midIndex; j < len; j++) rightArr[j - midIndex] = obj[j];

        sort(leftArr);
        sort(rightArr);

        mergeSort(leftArr, rightArr, obj);
    }

    private <T extends Comparable<T>> void mergeSort(T[] leftArray, T[] rightArray, T[] objArray) {
        int leftIndex, rightIndex,  objIndex;
        leftIndex = rightIndex = objIndex = 0;
        int leftSize = leftArray.length, rightSize = rightArray.length;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0)
                objArray[objIndex++] = leftArray[leftIndex++];
            else objArray[objIndex++] = rightArray[rightIndex++];
        }

        while (leftIndex < leftSize) objArray[objIndex++] = leftArray[leftIndex++];
        while (rightIndex < rightSize) objArray[objIndex++] = rightArray[rightIndex++];
    }
}