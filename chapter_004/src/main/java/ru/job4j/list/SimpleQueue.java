package ru.job4j.list;

public class SimpleQueue<T> {
    private int size = 0;
    private Node<T> node = null;

    public T poll() {
        Node<T> result = this.node;
        for (int i = 0; i < size - 1; i++) {
            result = result.next;
        }
        size--;
        return result.info;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = this.node;
        this.node = node;
        size++;
    }

    private class Node<T> {
        T info;
        Node<T> next;

        private Node(T info) {
            this.info = info;
        }
    }
}
