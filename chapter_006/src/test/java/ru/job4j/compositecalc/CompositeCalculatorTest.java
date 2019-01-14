package ru.job4j.compositecalc;

import org.junit.Test;
import ru.job4j.calculator.SubZeroMultipleException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CompositeCalculatorTest {
    String[] asks = {"1", "+", "1", "-", "3", "*", "-6", ":", "2", "%", "300", "^", "2"};
    CalculatorManager cm = new CalculatorManager();
    int position = 0;
    double tempRes = 0.0;
    double firstRes = 2.0;
    double secondRes = -1.0;
    double thirdRes = 6.0;
    double forthRes = 3.0;
    double fifthRes = 9.0;
    double sixthRes = 81.0;

    @Test
    public void whenTryToUseAllFunctionsThenDoIt() throws SubZeroMultipleException {
        tempRes = cm.working(Double.parseDouble(asks[position++]), asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(firstRes));
        tempRes = cm.working(tempRes, asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(secondRes));
        tempRes = cm.working(tempRes, asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(thirdRes));
        tempRes = cm.working(tempRes, asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(forthRes));
        tempRes = cm.working(tempRes, asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(fifthRes));
        tempRes = cm.working(tempRes, asks[position++], Double.parseDouble(asks[position++]));
        assertThat(tempRes, is(sixthRes));
    }
}
