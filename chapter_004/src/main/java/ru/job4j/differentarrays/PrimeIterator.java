package ru.job4j.differentarrays;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {
    private int[] array;
    private int index;

    public PrimeIterator(int[] array) {
        this.array = array;
        this.index = 0;
    }

    public boolean hasNext() {
        this.verify();
        return array.length > index;
    }

    public Integer next() {
        if (array.length <= index) {
            throw new NoSuchElementException();
        }
        this.verify();
        return array[index++];
    }


    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void verify() {
        boolean tooBig = index == array.length;
        while (!tooBig && !this.isPrime(array[index])) {
            this.index++;
            tooBig = this.index > this.array.length - 1;
        }
    }

    private boolean isPrime(int test) {
        boolean prime = true;
        for (int i = 2; i < test / 2; i++) {
            if (test % i == 0) {
                prime = false;
            }
        }
        if (test >= -1 && test <= 1 || Math.abs(test) == 4) {
            prime = false;
        }
        if (test == 2 || test == -2) {
            prime = true;
        }
        return prime;
    }
}
