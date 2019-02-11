package ru.job4j.secondcalculator;

import org.junit.Test;
import ru.job4j.secondcalculator.operations.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MainCalcTest {
    Operation operation;
    double a = 10;
    double b = 2;

    @Test
    public void whenTryToUseAddOperlicationThenAllWorksCorrectly() {
        operation = new Add("+");
        assertThat(operation.function(a, b), is(12.0));
    }

    @Test
    public void whenTryToUseMultiplyOperlicationThenAllWorksCorrectly() {
        operation = new Multiply("*");
        assertThat(operation.function(a, b), is(20.0));
    }

    @Test
    public void whenTryToUseDivideOperlicationThenAllWorksCorrectly() {
        operation = new Divide("/");
        assertThat(operation.function(a, b), is(5.0));
    }

    @Test
    public void whenTryToUseSubtrackOperlicationThenAllWorksCorrectly() {
        operation = new Subtract("-");
        assertThat(operation.function(a, b), is(8.0));
    }

    @Test
    public void whenTryToUsePowOperlicationThenAllWorksCorrectly() {
        operation = new Pow("pow");
        assertThat(operation.function(a, b), is(100.0));
    }

    @Test
    public void whenTryToUsePercentOperlicationThenAllWorksCorrectly() {
        operation = new Percent("%");
        assertThat(operation.function(a, b), is(0.2));
    }
}
