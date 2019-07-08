package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FieldTest {
    Calculator calc = new Calculator();
    ArrayList<Double> buffer = new ArrayList<>();

    @Test
    public void whenTryToUseCalcFunctionThenDoIt() {
        calc.multiple(0, 5, 1,
                (one, two) -> (double) one * two,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)));
        buffer.clear();
        calc.multiple(0, 5, 1,
                (one, two) -> (double) one + two,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)));
        buffer.clear();
        calc.multiple(0, 5, 1,
                (first, second) -> (double) (first + second) / 2,
                buffer::add
        );
        assertThat(buffer, is(Arrays.asList(0.5, 1.0, 1.5, 2.0, 2.5, 3.0)));
    }
}
