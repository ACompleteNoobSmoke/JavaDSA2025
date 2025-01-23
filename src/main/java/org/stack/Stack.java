package org.stack;

public class Stack<T> {

    private T[] stack;
    private int capacity;

    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.stack = (T[]) new Object[capacity];
    }

    private boolean isEmpty() { return size == 0;}

    private boolean isFull() { return size == capacity; }

}
