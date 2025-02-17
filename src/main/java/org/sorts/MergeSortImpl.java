//package org.sorts;
//
//import java.util.Random;
//
//public class MergeSortImpl {
//
//    private final Random rand;
//
//    public MergeSortImpl() {
//        this.rand = new Random();
//    }
//
//    public Integer[] initInitArray(int cap) {
//        Integer[] arr = new Integer[cap];
//        for (int i = 0; i < cap; i++) arr[i] = rand.nextInt(cap);
//        return arr;
//    }
//
//    private <T> void printArray(T[] arr) {
//        for (T e : arr) System.out.print(e.toString() + " ");
//    }
//
//    public static void main(String[] args) {
//        MergeSortImpl mergeSortImpl = new MergeSortImpl();
//        Integer[] arr = mergeSortImpl.initInitArray(50);
//        System.out.println("*** Before Sort ***");
//        mergeSortImpl.printArray(arr);
//        new MergeSortPractice(arr);
//        System.out.println("\n\n*** After Sort ***");
//        mergeSortImpl.printArray(arr);
//    }
//}
