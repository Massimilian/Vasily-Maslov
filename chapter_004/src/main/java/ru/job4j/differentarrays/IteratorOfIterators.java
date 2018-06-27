package ru.job4j.differentarrays;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators implements Iterator<Integer> {

    private Iterator<Integer>[] intArray;
    private int index;

    public IteratorOfIterators(Iterator<Integer>[] intArray) {
        this.intArray = intArray;
        this.index = 0;
    }

    public boolean hasNext() {
        return intArray[index].hasNext() ? intArray.length >= index + 1 : intArray.length > index + 1;
    }


    public Integer next() {
        if (intArray.length == index + 1 && !intArray[index].hasNext()) {
            throw new NoSuchElementException();
        }
        return !intArray[index].hasNext() ? intArray[++index].next() : intArray[index].next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
