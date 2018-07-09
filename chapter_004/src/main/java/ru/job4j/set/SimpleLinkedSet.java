package ru.job4j.set;

import ru.job4j.list.DinamicLinkedContainer;

import java.util.Iterator;

public class SimpleLinkedSet<E> implements Iterable<E> {

    private DinamicLinkedContainer<E> dlc = new DinamicLinkedContainer<>();

    public void add(E e) {
        if (dlc.getNode() == null) {
            dlc.add(e);
        }
        if (!this.contains(e)) {
            dlc.add(e);
        }
    }

    private boolean contains(E value) {
        boolean result = false;
        int max = dlc.getSize();
        for (int i = 0; i < max; i++) {
            if (value.equals(this.dlc.get(i))) {
                result = true;
                break;
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        return dlc.iterator();
    }
}