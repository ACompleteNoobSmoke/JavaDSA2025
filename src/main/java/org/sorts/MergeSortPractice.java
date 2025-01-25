package org.sorts;

public class MergeSortPractice {

    public <T extends Comparable<T>> MergeSortPractice (T[] objectArray) {
        mergeSort(objectArray);
    }

    private <T extends Comparable<T>> T[] mergeSort(T[] objArr) {
        int len = objArr.length;
        if (len < 2) return objArr;

        int midIndex = len / 2;
        T[] leftArr = (T[]) new Comparable[midIndex];
        T[] rightArr = (T[]) new Comparable[len - midIndex];

        for (int i = 0; i < midIndex; i++) leftArr[i] = objArr[i];
        for (int i = midIndex; i < len; i++) rightArr[i - midIndex] = objArr[i];

        mergeSort(leftArr);
        mergeSort(rightArr);

        return merge(leftArr, rightArr, objArr);
    }

    private <T extends Comparable<T>> T[] merge(T[] leftArr, T[] rightArr, T[] objArr) {
        int leftIndex = 0, rightIndex = 0, objIndex = 0;
        int leftSize = leftArr.length, rightSize = rightArr.length;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArr[leftIndex].compareTo(rightArr[rightIndex]) <= 0)
                objArr[objIndex++] = leftArr[leftIndex++];
            else objArr[objIndex++] = rightArr[rightIndex++];
        }

        while (leftIndex < leftSize) objArr[objIndex++] = leftArr[leftIndex++];
        while (rightIndex < rightSize) objArr[objIndex++] = rightArr[rightIndex++];

        return objArr;
    }
}
