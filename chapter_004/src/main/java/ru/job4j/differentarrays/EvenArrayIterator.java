package ru.job4j.differentarrays;

import java.util.Iterator;

public class EvenArrayIterator implements Iterator<Integer> {
    private int[] array;
    private int index;

    public EvenArrayIterator(int[] array) {
        this.array = array;
        this.index = 0;
    }

    public boolean hasNext() {
        this.verify();
        return array.length > index;
    }

    public Integer next() throws ArrayIndexOutOfBoundsException {
        this.verify();
        return array[index++];
    }


    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void verify() {
        boolean tooBig = false;
        while (!tooBig && this.array[this.index] % 2 != 0) {
            this.index++;
            tooBig = this.index > this.array.length - 1;
        }
    }
}
