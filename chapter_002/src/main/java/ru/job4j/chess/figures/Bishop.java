package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.*;

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException { // проверку возможности хода сделал тут. В методе move класса Board не вижу возможности проверить путь.
        if (this.canGo(source, dest)) {
            System.out.println("You made your choice.");
        } else {
            throw new ImpossibleMoveException("Can't go here.");
        }
        Cell[] moves = new Cell[Math.abs(source.getPosX() - dest.getPosX()) + 1];
        for (int i = 0; i < moves.length; i++) {
            Cell cell = new Cell();
            if (source.getPosX() > dest.getPosX()) {
                cell.setPosX(source.getPosX() - i);
            } else {
                cell.setPosX(dest.getPosX() - i);
            }
            if (source.getPosY() > dest.getPosY()) {
                cell.setPosY(source.getPosY() - i);
            } else {
                cell.setPosY(dest.getPosY() - i);
            }
            moves[i] = cell;
        }
        return moves;
    }

    protected boolean canGo(Cell source, Cell dest) {
        boolean can = false;
        if (source.getPosX() - source.getPosY() == dest.getPosX() - dest.getPosY() || source.getPosX() + source.getPosY() == dest.getPosX() + source.getPosY()) {
            can = true;
        }
        return can;
    }
}