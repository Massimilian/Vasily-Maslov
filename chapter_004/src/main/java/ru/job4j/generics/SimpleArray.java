package ru.job4j.generics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int count = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        System.out.println("Attention! This class has limited size.");
    }

    public void add(T model) {
        try {
            while (this.objects[count] != null) {
                count++;
            }
            this.objects[count++] = model;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Impossible! This is a limited size class.");
        }
    }

    public void add(int index, T model) {
        try {
            this.objects[index] = model;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Impossible! This is a limited size class.");
        }
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void delete(int index) {
        this.objects[index] = null;
    }

    public <T> T get(int index) {
        return (T) this.objects[index];
    }

    public int findIndex(T model) {
        int result = -1;
        for (int i = 0; i < this.count; i++) {
            if (model.equals(this.objects[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int itCount = 0;

            @Override
            public boolean hasNext() {
                return count > itCount;
            }

            @Override
            public T next() {
                return (T) objects[itCount++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
