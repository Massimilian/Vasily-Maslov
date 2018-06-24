package ru.job4j.doublearray;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    private int[] values;
    private int index;

    public ArrayIterator(int[] values) {
        this.values = values;
        index = 0;
    }

    public boolean hasNext() {
        return values.length > index;
    }

    public Integer next() {
        return values[index++];
    }

    public void remove() {
        int[] result = new int[this.values.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i < this.index ? values[i] : values[i + 1];
        }
        values = result;
    }
}
