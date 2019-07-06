package ru.job4j.lambda;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class NumberPrepareTest {
    private NumberPrepare test = new NumberPrepare();
    private int[] arrayOne = {1, 2, 3, 4, 5, 6};
    private int[] arrayTwo = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int resultOne = (int) (Math.pow(2.0, 2.0) + Math.pow(4.0, 2.0) + Math.pow(6.0, 2.0));
    private int resultTwo = resultOne + (int) Math.pow(8.0, 2.0);

    @Test
    public void whenTryToMethodGoThenDoIt() {
        assertThat(test.change(arrayOne), is(resultOne));
        assertThat(test.change(arrayTwo), is(resultTwo));
    }
}

