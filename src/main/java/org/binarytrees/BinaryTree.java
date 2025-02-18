package org.binarytrees;

import org.Node;

public class BinaryTree<T extends Comparable<T>> {

   private Node<T> root;

    public BinaryTree(T data) {
        this.root = new Node<T>(data);
    }

    public BinaryTree() {}

    private boolean isEmpty() {
        return this.root == null;
    }

    private boolean isNull(Node<T> focusNode) {
        return focusNode == null;
    }

    private T getMin(Node<T> focusNode) {
        if (!isNull(focusNode.getLeft())) 
            return getMin(focusNode.getLeft());
        return focusNode.getData();
    }

    private T getMax(Node<T> focusNode) {
        if (!isNull(focusNode.getRight()))
            return getMax(focusNode.getRight());
        return focusNode.getData();
    }

    public void add(T data) {
        if (isEmpty()) root = new Node<T>(data);
        else insertIntoTree(data, root);
    }

    public T search(T data) {
        if (isEmpty()) return null;
        return searchTree(data, root);
    }

    public void delete(T data) {
        if (isEmpty()) return;
        root = removeFromTree(data, root);
    }

    public void traversals(int choice) {
        switch(choice) {
            case 1 -> preOrderTraversal(root);
            case 2 -> postOrderTraversal(root);
            default -> inOrderTraversal(root);
        }
    }

    private void insertIntoTree(T data, Node<T> focusNode) {
        if (data.compareTo(focusNode.getData()) <= 0) {
            if (isNull(focusNode.getLeft())) focusNode.setLeft(new Node<T>(data));
            else insertIntoTree(data, focusNode.getLeft());
        } else {
            if (isNull(focusNode.getRight())) focusNode.setRight(new Node<T>(data));
            else insertIntoTree(data, focusNode.getRight());
        }
    }

    private T searchTree(T data, Node<T> focusNode) {
        while (data.compareTo(focusNode.getData()) != 0) {
            if (data.compareTo(focusNode.getData()) < 0) focusNode = focusNode.getLeft();
            else focusNode = focusNode.getRight();
            if (focusNode == null) return null;
        }
        return focusNode.getData();
    }

    private Node<T> removeFromTree(T data, Node<T> focusNode) {
        if (data.compareTo(focusNode.getData()) < 0) 
            focusNode.setLeft(removeFromTree(data, focusNode.getLeft()));
        else if (data.compareTo(focusNode.getData()) > 0)
            focusNode.setRight(removeFromTree(data, focusNode.getRight()));
        else {
            if (isNull(focusNode.getLeft())) return focusNode.getRight();
            else if (isNull(focusNode.getRight())) return focusNode.getLeft();

            focusNode.setData(getMax(focusNode.getLeft()));
            focusNode.setLeft(removeFromTree(data, focusNode.getLeft()));
        }

        return focusNode;
    }

    private void preOrderTraversal(Node<T> focusNode) {
        if (!isNull(focusNode)) {
            System.out.println(focusNode);
            preOrderTraversal(focusNode.getLeft());
            preOrderTraversal(focusNode.getRight());
        }
    }

    private void postOrderTraversal(Node<T> focusNode) {
        if (!isNull(focusNode)) {
            postOrderTraversal(focusNode.getLeft());
            postOrderTraversal(focusNode.getRight());
            System.out.println(focusNode);
        }
    }

    private void inOrderTraversal(Node<T> focusNode) {
        if (!isNull(focusNode)) {
            inOrderTraversal(focusNode.getLeft());
            System.out.println(focusNode);
            inOrderTraversal(focusNode.getRight());
        }
    }

}
