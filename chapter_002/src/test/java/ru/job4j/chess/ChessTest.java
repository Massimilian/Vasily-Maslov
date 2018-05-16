package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleCellException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Bishop;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class ChessTest {
	@Test
	public void whenMoveTheChessThenPrintItsMove() throws ImpossibleCellException, OccupiedWayException, FigureNotFoundException {
	Cell source = new Cell(6, 2);
    Cell dest = new Cell(5, 1);
    Board board = new Board();
	board.add(new Bishop(source));
    board.move(source, dest);
	assertThat(board.figures[0].getPosition(), is(dest));
	}
}