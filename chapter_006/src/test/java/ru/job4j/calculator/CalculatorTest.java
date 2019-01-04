package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    TestCalc test = new TestCalc();

    @Test
    public void whenTryToUsePlusFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"1", "1", "+"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(2.0));
    }

    @Test
    public void whenTryToUseMinusFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"3", "1", "-"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(2.0));
    }

    @Test
    public void whenTryToUseMultipleFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"3", "1", "*"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(3.0));
    }

    @Test
    public void whenTryToUseDividingFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"8", "2", "/"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(4.0));
    }

    @Test
    public void whenTryToUsePercentFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"250", "2", "%"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(5.0));
    }

    @Test
    public void whenTryToUsePowFunctionThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"2", "10", "pow"});
        test.operationFirst();
        test.operationSecond();
        test.choosing();
        test.calc();
        assertThat(test.getResult(), is(1024.0));
    }

    @Test
    public void whenTryToUseAllFunctionsThenReturnResult() throws SubZeroMultipleException, OperationException {
        test.setAsks(new String[]{"1", "1", "+", "3", "-", "-5", "*", "2", "/", "400", "%", "3", "pow"});
        test.operationFirst();
        for (int i = 0; i < 6; i++) {
            test.operationSecond();
            test.choosing();
            test.calc();
            test.setFirst((double) test.getResult());
        }
        assertThat(test.getResult(), is(1000.0));
    }


}
