package ru.job4j.list;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<e> {
    private int size;
    private Node<e> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<e> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete() {
        return null;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<e> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<e> {
        E date;
        Node<e> next;

        Node(E date) {
            this.date = date;
        }
    }
}
