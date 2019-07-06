package ru.job4j.lambda;

import java.util.Arrays;

public class NumberPrepare {
    /**
     * Method that compares array to integers and return the sum of squares of evens.
     *
     * @param array
     * @return result
     */
    public int change(int[] array) {
        return (Arrays.stream(array).filter(x -> x % 2 == 0).map(x -> (int) Math.pow(x, 2.0)).reduce((a, b) -> a + b)).getAsInt();
    }
}
