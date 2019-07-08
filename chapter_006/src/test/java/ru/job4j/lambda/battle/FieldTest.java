package ru.job4j.lambda.battle;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FieldTest {
    Field test = new Field();

    @Test
    public void whenTryTiFightThenEnsureThatAllIsWorkingWell() {
        assertThat(test.getDarkUnits().size() == test.getLightUnits().size(), is(true));
        assertThat(test.getLightUnits().size(), is(8));
        test.info();
        assertThat(test.isDown(), is(false));
        while (!test.isDown()) {
            test.battle();
        }
        assertThat(test.isDown(), is(true));
        test.info();
        test.end();
    }
}
