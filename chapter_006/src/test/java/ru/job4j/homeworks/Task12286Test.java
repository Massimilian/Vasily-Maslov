package ru.job4j.homeworks;

import org.junit.Test;
import ru.job4j.homeworks.task12285.Figure;
import ru.job4j.homeworks.task12285.Queen;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task12286Test {
    private Task12286 test = new Task12286();
    private Figure figureOne;
    private Figure figureTwo;

    @Test
    public void whenTryToLookAtDangersOfFiguresThenDoIt() {
        figureOne = new Queen(4, 1);
        figureTwo = new Queen(4, 4);
        char[][] result = test.safePositions(figureTwo, figureOne);
        assertThat(result, is(new char[][]{{'+', '0', '0', '0', '+', '0', '0', '0'}, {'0', '*', '0', '0', '*', '0', '0', '+'}, {'0', '0', '+', '0', '+', '0', '+', '0'}, {'0', '0', '0', '+', '+', '+', '0', '0'}, {'*', '@', '*', '*', 'Q', '*', '*', '*'}, {'0', '0', '0', '+', '+', '+', '0', '0'}, {'0', '0', '+', '0', '+', '0', '+', '0'}, {'0', '*', '0', '0', '*', '0', '0', '+'}}));
    }
}
