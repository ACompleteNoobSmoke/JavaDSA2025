package org.binarytrees;
import java.util.Random;
import java.util.Stack;

import org.Node;

public class DepthFirstValues {

    private int[] randomNums (int cap) {
        int[] arr = new int[cap];
        Random random = new Random();
        for(int i = 0; i < cap; i++) arr[i] = random.nextInt(30);
        return arr;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        //int[] nums = new DepthFirstValues().randomNums(30);
        int[] nums = {6, 4, 7, 3, 5, 9}; // 6, 4, 3, 5, 7, 9
        System.out.print("Original Numbers: ");
        for (int n: nums) {
            System.out.print(n + " ");
            tree.add(n); 
        }
        System.out.println();
        System.out.print("Depth First Values: ");
        tree.depthValues();
        System.out.println();
        System.out.print("Breadth First Values: ");
        tree.breadthValues();
        
    }
    
}
