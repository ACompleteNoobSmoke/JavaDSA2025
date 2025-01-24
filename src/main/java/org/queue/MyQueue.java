package org.queue;

public class MyQueue<T> {
    private T[] queue;
    private int capacity;
    private int size;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.queue = (T[]) new Object[capacity];
    }

    private boolean isEmpty() { return size == 0; }
    private boolean isFull() { return size == capacity; }

    public boolean enqueue(T newElement) {
        if (isFull()) return false;
        this.queue[size++] = newElement;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T removedElment = this.queue[0];
        resize();
        size--;
        return removedElment;
    }

    private void resize() {
        if (size == 1){
            this.queue[0] = null;
            return;
        }
        for (int i = 0; i < size - 1; i++) this.queue[i] = queue[i + 1];
    }

    public T peek() {
        return this.queue[0];
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("Queue is currently empty");
            return;
        }
        for (int i = 0; i < size; i++) System.out.println(this.queue[i]);
    }

}
