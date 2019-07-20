package ru.job4j.collection;

import net.jcip.annotations.ThreadSafe;

import java.util.*;

@ThreadSafe
/**
 * Thread-safe collection with all List methods and LinkedList
 */

public class ThreadSafeCollection<E> implements List {
    private final LinkedList<E> list = new LinkedList<E>();

    @Override
    public int size() {
        synchronized (list) {
            return list.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (list) {
            return list.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (list) {
            return list.contains(o);
        }

    }

    @Override
    public Iterator iterator() {
        synchronized (list) {
            return copy().iterator();
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (list) {
            return list.toArray();
        }
    }

    @Override
    public boolean add(Object o) {
        synchronized (list) {
            return list.add((E) o);
        }
    }

    @Override
    public boolean remove(Object o) {
        synchronized (list) {
            return list.remove(o);
        }
    }

    @Override
    public boolean addAll(Collection c) {
        synchronized (list) {
            return list.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, java.util.Collection c) {
        synchronized (list) {
            return list.addAll(index, c);
        }
    }

    @Override
    public void clear() {
        synchronized (list) {
            list.clear();
        }
    }

    @Override
    public Object get(int index) {
        synchronized (list) {
            return list.get(index);
        }
    }

    @Override
    public Object set(int index, Object element) {
        synchronized (list) {
            return list.set(index, (E) element);
        }
    }

    @Override
    public void add(int index, Object element) {
        synchronized (list) {
            list.add(index, (E) element);
        }
    }

    @Override
    public Object remove(int index) {
        synchronized (list) {
            return list.remove(index);
        }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (list) {
            return list.indexOf(o);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        synchronized (list) {
            return list.lastIndexOf(o);
        }
    }

    @Override
    public ListIterator listIterator() {
        synchronized (list) {
            return copy().listIterator();
        }
    }

    @Override
    public ListIterator listIterator(int index) {
        synchronized (list) {
            return copy().listIterator(index);
        }
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        synchronized (list) {
            return list.subList(fromIndex, toIndex);
        }
    }

    @Override
    public boolean retainAll(java.util.Collection c) {
        synchronized (list) {
            return list.retainAll(c);
        }
    }

    @Override
    public boolean removeAll(java.util.Collection c) {
        synchronized (list) {
            return list.removeAll(c);
        }
    }

    @Override
    public boolean containsAll(java.util.Collection c) {
        synchronized (list) {
            return list.containsAll(c);
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        synchronized (list) {
            return list.toArray(a);
        }
    }

    private List copy() {
        synchronized (list) {
            return (LinkedList) list.clone();
        }
    }
}
