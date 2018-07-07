package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private Node<T> node = null;

    public T poll() {
        if (this.node == null) {
            throw new NoSuchElementException("There's no more elements");
        }
        Node result = this.node;
        this.node = node.next;
        return (T) result.info;
    }

    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.next = this.node;
        this.node = node;
    }

    private class Node<T> {
        T info;
        Node<T> next;

        private Node(T info) {
            this.info = info;
        }
    }
}
