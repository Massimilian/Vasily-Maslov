package ru.job4j.set;

import java.util.Iterator;

import ru.job4j.list.DinamicContainer;

public class SimpleSet<E> implements Iterable<E> {
    private DinamicContainer<E> dc = new DinamicContainer<>();

    public void add(E e) {
        boolean isEqual = false;
        int max = dc.getCount();
        for (int i = 0; i <= max; i++) {
            if (e.equals(this.dc.get(i))) {
                isEqual = true;
            }
        }
        if (!isEqual) {
            dc.add(e);
        }
    }

    public E get(int index) {
        return dc.get(index);
    }

    @Override
    public Iterator<E> iterator() {
        return dc.iterator();
    }
}
