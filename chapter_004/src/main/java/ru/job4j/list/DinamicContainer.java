package ru.job4j.list;

import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class DinamicContainer<E> implements Iterable<E> {

    private int size = 10;
    private int count = 0;

    @GuardedBy("this")
    private Object[] container = new Object[size];

    public int getCount() {
        synchronized (container) {
            return count;
        }
    }

    public void add(E value) {
        synchronized (container) {
            this.grow();
            this.container[count++] = value;
        }
    }

    public E get(int index) {
        synchronized (container) {
            return (E) container[index];
        }
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
