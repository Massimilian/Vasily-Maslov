package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicContainer<E> implements Iterable<E> {

    private int size = 10;
    private int count = 0;
    private Object[] container = new Object[size];

    public void add(E value) {
        this.grow();
        this.container[count++] = value;
    }

    public E get(int index) {
        return (E) container[index];
    }


    private void grow() {
        if (count == size) {
            int tempSize = this.size;
            this.size += (this.size >> 1);
            Object[] upgradeContainer = new Object[this.size];
            System.arraycopy(this.container, 0, upgradeContainer, 0, tempSize);
            this.container = upgradeContainer;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int itCount = 0;
            int modCount = count;

            @Override
            public boolean hasNext() {
                findException();
                return itCount < count;
            }

            @Override
            public E next() {
                findException();
                if (this.itCount == count) {
                    throw new NoSuchElementException("Out of bounds!");
                }
                return (E) container[itCount++];
            }

            private void findException() {
                if (modCount != count) {
                    throw new ConcurrentModificationException("This Iterator cannot work!");
                }
            }
        };
    }
}
