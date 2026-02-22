package org.binarytrees;

import org.Node;

import java.util.*;

public class Practice <T extends Comparable<T>>{

    Node<T> root;

    public Practice() {
        root = null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private T getMin(Node<T> currentNode) {
        if (currentNode.getLeft() != null) {
            return getMin(currentNode.getLeft());
        }
        return currentNode.getData();
    }

    private T getMax(Node<T> currentNode) {
        if (currentNode.getRight() != null)
           return getMax(currentNode.getRight());
        return currentNode.getData();
    }

    public void add(T value) {
        root = (isEmpty())
                ? new Node<>(value)
                : insertIntoBinaryTree(root, value);
    }

    public T search(T value) {
        return (isEmpty())
                ? null
                : searchFromTree(root, value);
    }


    private Node<T> insertIntoBinaryTree(Node<T> currentRoot, T value) {
        if (currentRoot == null) return currentRoot;
        else if (value.compareTo(currentRoot.getData()) < 0) currentRoot.setLeft(insertIntoBinaryTree(currentRoot.getLeft(), value));
        else currentRoot.setRight(insertIntoBinaryTree(currentRoot.getRight(), value));
        return currentRoot;
    }

    private T searchFromTree(Node<T> currentRoot, T value) {
        while (!currentRoot.getData().equals(value)) {
            if (currentRoot.getData().compareTo(value) > 0) currentRoot = currentRoot.getLeft();
            else if (currentRoot.getData().compareTo(value) < 0) currentRoot = currentRoot.getRight();
            if (currentRoot == null) return null;
        }
        return currentRoot.getData();
    }

    private Node<T> removeFromTree(Node<T> currentNode, T value) {
        if (currentNode.getData().compareTo(value) > 0)
            currentNode.setLeft(removeFromTree(currentNode.getLeft(), value));
        else if (currentNode.getData().compareTo(value) < 0)
            currentNode.setRight(removeFromTree(currentNode.getRight(), value));
        else {
            if (currentNode.getLeft() == null) return currentNode.getRight();
            else if (currentNode.getRight() == null) return currentNode.getLeft();

            currentNode.setData(getMax(currentNode.getLeft()));
            currentNode.setLeft(removeFromTree(currentNode.getLeft(), value));
        }
        return currentNode;
    }

    public void preOrderTraversal(Node<T> currentNode) {
        if (currentNode != null) {
            preOrderTraversal(currentNode.getLeft());;
            System.out.print(currentNode.getData() + " ");
            preOrderTraversal(currentNode.getRight());
        }
    }

    public void postOrderTraversal(Node<T> currentNode) {
        if (currentNode != null) {
            postOrderTraversal(currentNode.getLeft());
            postOrderTraversal(currentNode.getRight());
            System.out.print(currentNode.getData() + " ");
        }
    }

    public void inOrderTraversal(Node<T> currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            inOrderTraversal(currentNode.getLeft());
            inOrderTraversal(currentNode.getRight());
        }
    }

    public Node<T> depthFirstSearch(Node<T> currentNode, T value) {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(currentNode);
        while (!stack.isEmpty()) {
            Node<T> curr = stack.pop();
            if (curr.getData().equals(value)) return curr;
            if (curr.getLeft() != null) stack.push(curr.getLeft());
            if (curr.getRight() != null) stack.push(curr.getRight());
        }
        return null;
    }

    public Node<T> breadthFirstSearch(Node<T> currentNode, T value) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            Node<T> curr = queue.poll();
            if (curr.getData().equals(value)) return curr;
            if (curr.getLeft() != null) queue.add(curr.getLeft());
            if (curr.getRight() != null) queue.add(curr.getRight());
        }
        return null;
    }

    public int levelOrderTraversal(Node<T> currentNode, T value) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(currentNode);
        int level = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            if (queue.peek().getData().equals(value)) return level;
            for (int i = 0; i < currSize; i++) {
                Node<T> curr = queue.poll();
                if (curr.getLeft() != null) queue.add(curr.getLeft());
                if (curr.getRight() != null) queue.add(curr.getRight());
            }
            level++;
        }
        return level;
    }

    public int question(int[] nums, int k) {
       int count = 0;
       for (int i = 0; i < nums.length; i++) {
           int sum = nums[i];
           if (sum == k) count++;
           for (int j = i + 1; j < nums.length; j++) {
               sum += nums[j];
               if (sum == k) count++;
           }
       }
       return count;
    }

    public int prefix(int[] nums, int key) {
        int sum = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("KEY: %s || VALUE: %s", entry.getKey(), entry.getValue());
            System.out.println();
        }

        return map.get(key);
    }

    static void main() {
        Practice practice = new Practice();
        int[] nums = {1, 1, 1};
        System.out.println(practice.prefix(nums, 2));
    }


}
