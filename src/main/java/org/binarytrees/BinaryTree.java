package org.binarytrees;

import org.Node;

public class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinaryTree() {
    }

    private Node<T> getMin(Node<T> focusNode) {
        if (focusNode.getLeft() != null)
            return getMin(focusNode.getLeft());
        return focusNode;
    }

    private Node<T> getMax(Node<T> focusNode) {
        if (focusNode.getRight() != null)
            return getMax(focusNode.getRight());
        return focusNode;
    }

    public void insert(T value) {
        if (root == null) root = new Node<>(value);
        else add(value, root);
    }

    public void add(T value, Node<T> focusNode ) {
        int compare = root.getData().compareTo(value);
        if (compare <= 0) {
            if (focusNode.getLeft() == null) focusNode.setLeft(new Node<>(value));
            else add(value, focusNode.getLeft());
        }else {
            if (focusNode.getRight() == null) focusNode.setRight(new Node<>(value));
            else add(value, focusNode.getRight());
        }
    }

    public void print(int type) {
        if (type == 1) preOrder(root);
        else if (type == 2) postOrder(root);
        else inOrder(root);
    }

    public void preOrder(Node<T> focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.getData());
            preOrder(focusNode.getLeft());
            preOrder(focusNode.getRight());
        }
    }

    public void inOrder(Node<T> focusNode) {
        if (focusNode != null) {
            inOrder(focusNode.getLeft());
            System.out.println(focusNode.getData());
            inOrder(focusNode.getRight());
        }
    }

    public void postOrder(Node<T> focusNode) {
        if (focusNode != null) {
            postOrder(focusNode.getLeft());
            postOrder(focusNode.getRight());
            System.out.println(focusNode.getData());
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        int[] arrNums = {5, 3, 0, 1, 7, 10};
        for (int i : arrNums) {
            tree.insert(i);
        }

        tree.print(2);
    }

}
