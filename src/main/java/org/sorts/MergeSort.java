package org.sorts;

public class MergeSort<T extends Comparable<T>> {

    public MergeSort() {

    }

    public T[] sort(T[] obj) { return mergeSort(obj); }

    private T[] mergeSort(T[] objArray) {
        int len = objArray.length;
        if (len < 2) return objArray;

        int midIndex = len / 2;
        T[] leftArray = (T[]) new Comparable[midIndex];
        T[] rightArray = (T[]) new Comparable[len - midIndex];

        for (int i = 0; i < midIndex; i++) leftArray[i] = objArray[i];
        for (int j = midIndex; j < len; j++) rightArray[j - midIndex] = objArray[j];

        mergeSort(leftArray); mergeSort(rightArray);

        return merge(leftArray, rightArray, objArray);
    }

    private T[] merge(T[] leftArr, T[] rightArr, T[] objArr) {
        int leftCounter = 0, rightCounter = 0, ogCounter = 0;
        int leftSize = leftArr.length, rightSize = rightArr.length;

        while (leftCounter < leftSize && rightCounter < rightSize) {
            if (leftArr[leftCounter].compareTo(rightArr[rightCounter]) <= 0)
                objArr[ogCounter] = leftArr[leftCounter++];
            else objArr[ogCounter] = rightArr[rightCounter++];
            ogCounter++;
        }

        while (leftCounter < leftSize) objArr[ogCounter++] = leftArr[leftCounter++];
        while (rightCounter < rightSize) objArr[ogCounter++] = rightArr[rightCounter++];

        return objArr;
    }
}