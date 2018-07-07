package ru.job4j.list;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private int size = 10;
    private Object[] container = new Object[size];
    private int count = 0;

    public T poll() {
        if (count == 0) {
            throw new NoSuchElementException("Stack is empty!");
        }
        T t = (T) container[--count];
        container[count] = null;
        return t;
    }

    public void push(T value) {
        this.grow();
        container[count++] = value;
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
}
