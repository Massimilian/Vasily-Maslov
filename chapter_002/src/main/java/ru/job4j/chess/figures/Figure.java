package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.*;

public abstract class Figure {
    final private Cell position;

    public Figure(Cell position) {
        this.position = position;
    }
    
	public abstract Figure copy(Cell dest);

    abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract boolean canGo(Cell source, Cell dest);

    void printMove(Cell[] moves) {
        for (int i = moves.length - 1; i >= 0; i--) {
            System.out.println("Move + " + (char) (moves[i].getPosX() + 64) + "" + moves[i].getPosY() + ".");
        }
    }
	
	public Cell getPosition() {
		return this.position;
	}
}