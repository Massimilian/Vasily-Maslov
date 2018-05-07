package ru.job4j.chess;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChessTest {
//	private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
//  private final PrintStream out = System.out;
//	System.setOut(new PrintStream(this.mem));

	@Test
	public void whenMoveTheChessThenPrintItsMove() {
	Cell source = new Cell(6, 2);
    Cell dest = new Cell(5, 1);
    Board board = new Board();
	board.add(new Bishop(source));
    board.move(source, dest);
	assertThat(board.figures[0].getPosition(), is(dest));
	}
}