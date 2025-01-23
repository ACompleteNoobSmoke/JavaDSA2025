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

    public boolean push (T newElement) {
        if (isFull()) return false;
        stack[size++] = newElement;
        return true;
    }

    public T pop() {
        if (isEmpty()) return null;
        return stack[--size];
    }

    public T peek() {
        if (isEmpty()) return null;
        return stack[size - 1];
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println(stack.getClass().getName() +" Stack Is Currently Empty");
            return;
        }
        for (int i = size; i >= 0; i--)
            System.out.println(stack[i]);
    }

}
