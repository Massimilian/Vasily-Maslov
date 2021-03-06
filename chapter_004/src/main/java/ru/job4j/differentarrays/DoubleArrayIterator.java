package ru.job4j.differentarrays;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleArrayIterator implements Iterator<Integer> {
    private int[][] values;
    private int index;
    private int secondIndex;

    public DoubleArrayIterator(int[][] values) {
        this.values = values;
        index = 0;
        secondIndex = 0;
    }

    @Override
    public boolean hasNext() {
        //return values.length - 1 == index ? values[index].length > secondIndex ? true : false : true;
        return values.length - 1 > index || (values[index].length > secondIndex);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Error! There's no more elements!");
        }
        if (secondIndex == values[index].length) {
            secondIndex = 0;
            index++;
        }
        return values[index][secondIndex++];
    }

    @Override
    public void remove() {
        int[] result = new int[this.values[index].length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i < this.secondIndex ? values[index][i] : values[index][i + 1];
        }
        values[index] = result;
    }

}
