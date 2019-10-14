package ru.job4j.homeworks;

import org.junit.Test;
import ru.job4j.homeworks.task12285.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class Task12285Test {
    private Task12285 test = new Task12285();
    private char[][] board;
    private Figure elefant = new Elefant(2, 3);
    private Figure rook = new Rook(3, 3);
    private Figure queen = new Queen(4, 4);
    private Figure horse = new Horse(3, 1);

    @Test
    public void whenTryToUseElefantThenReturnDangers() {
        board = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}};
        char[][] result = test.figureAttack(board, elefant);
        assertThat(result, is(new char[][]{{'0', '*', '0', '0', '0', '*', '0', '0'}, {'0', '0', '*', '0', '*', '0', '0', '0'}, {'0', '0', '0', 'E', '0', '0', '0', '0'}, {'0', '0', '*', '0', '*', '0', '0', '0'}, {'0', '*', '0', '0', '0', '*', '0', '0'}, {'*', '0', '0', '0', '0', '0', '*', '0'}, {'0', '0', '0', '0', '0', '0', '0', '*'}, {'0', '0', '0', '0', '0', '0', '0', '0'},}));
    }

    @Test
    public void whenTryToUseRookThenReturnDangers() {
        board = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}};
        char[][] result = test.figureAttack(board, rook);
        assertThat(result, is(new char[][]{{'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'*', '*', '*', 'R', '*', '*', '*', '*'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}}));
    }

    @Test
    public void whenTryToUseQueenThenReturnDangers() {
        board = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}};
        char[][] result = test.figureAttack(board, queen);
        assertThat(result, is(new char[][]{{'*', '0', '0', '0', '*', '0', '0', '0'}, {'0', '*', '0', '0', '*', '0', '0', '*'}, {'0', '0', '*', '0', '*', '0', '*', '0'}, {'0', '0', '0', '*', '*', '*', '0', '0'}, {'*', '*', '*', '*', 'Q', '*', '*', '*'}, {'0', '0', '0', '*', '*', '*', '0', '0'}, {'0', '0', '*', '0', '*', '0', '*', '0'}, {'0', '*', '0', '0', '*', '0', '0', '*'}}));
    }

    @Test
    public void whenTryToUseHorseThenReturnDangers() {
        board = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}};
        char[][] result = test.figureAttack(board, horse);
        assertThat(result, is(new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'*', '0', '*', '0', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'0', 'H', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '*', '0', '0', '0', '0'}, {'*', '0', '*', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}}));
    }
}
