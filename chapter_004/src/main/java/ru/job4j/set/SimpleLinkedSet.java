package ru.job4j.set;

import ru.job4j.list.DinamicLinkedContainer;

import java.util.Iterator;

public class SimpleLinkedSet<E> implements Iterable<E> {

    private DinamicLinkedContainer<E> dlc = new DinamicLinkedContainer<>();

    public void add(E e) {
        boolean isEqual = false;
        int max = dlc.getSize();
        if (dlc.getNode() == null) {
            dlc.add(e);
        } else {
            for (int i = 0; i < max; i++) {
                if (e.equals(this.dlc.get(i))) {
                    isEqual = true;
                }
            }
            if (!isEqual) {
                dlc.add(e);
            }
        }
    }


    public Iterator<E> iterator() {
        return dlc.iterator();
    }
}