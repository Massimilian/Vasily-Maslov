package ru.job4j.lambda.casting;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.List;

public class CastMatrixTest {
    private CastMatrix cm = new CastMatrix();
    private Integer[][] test = {{1, 2, 3}, {4, 5, 6, 7}};
    private int count = 0;

    @Test
    public void whenTryToCastListOfIntegerArraysToOneListThenDoIt() {
        List<Integer> getted = cm.castListArray(test);
        getted.forEach(i -> assertThat(i, is(++count)));
    }
}
