package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DinamicLinkedContainer<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> node = null;

    public void add(E info) {
        Node<E> node = new Node<>(info);
        node.next = this.node;
        this.node = node;
        size++;
    }

    public E get(int index) {
        Node<E> result = this.node;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.info;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 1;
            int checkSize = size;

            @Override
            public boolean hasNext() {
                if (checkSize != size) {
                    throw new ConcurrentModificationException("This iterator can't work here!");
                }
                return count <= size;
            }

            @Override
            public E next() {
                if (checkSize != size) {
                    throw new ConcurrentModificationException("This iterator can't work here!");
                }
                DinamicLinkedContainer.Node it = node;
                for (int i = 0; i < size - count; i++) {
                    it = it.next;
                }
                count++;
                return (E) it.info;
            }
        };
    }

    private class Node<E> {
        E info;
        Node<E> next;

        private Node(E info) {
            this.info = info;
        }
    }
}
