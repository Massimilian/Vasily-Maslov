package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleCellException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Bishop;

public class Test {
    public static void main(String[] args) throws ImpossibleCellException, OccupiedWayException, FigureNotFoundException {
        Cell source = new Cell(6, 2);
//        Cell source1 = new Cell (7,2);
        Cell dest = new Cell(5, 1);
        Board board = new Board();
        board.add(new Bishop(source));
        board.move(source, dest);
    }
}
