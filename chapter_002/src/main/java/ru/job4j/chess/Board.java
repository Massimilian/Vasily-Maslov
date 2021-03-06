package ru.job4j.chess;

import ru.job4j.chess.figures.*;
import ru.job4j.chess.exceptions.*;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private int count = 0;
    private Figure[] figures = new Figure[32];

    void add(Figure figure) {
        boolean canSet = true;
        if (this.count >= this.figures.length) {
            canSet = false;
        }
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] == null) {
                break;
            }
            if (figure.getPosition().equals(this.figures[i].getPosition())) {
                canSet = false;
            }
        }
        if (canSet) {
            this.figures[this.count++] = figure;
        } else {
            System.out.println("You can't add a Figure!");
        }
    }

    boolean move(Cell source, Cell dest) throws OccupiedWayException, FigureNotFoundException {
        for (int i = 0; i < this.count; i++) {
            if (this.figures[i].getPosition().equals(dest)) {
                throw new OccupiedWayException("This cell is busy!");
            }
        }
        boolean haveFigure = false;
        for (int i = 0; i < this.count; i++) {
            if (this.figures[i].getPosition().equals(source)) {
                haveFigure = true;
                this.figures[i] = this.figures[i].copy(dest);
                break;
            }
        }
        if (!haveFigure) {
            throw new FigureNotFoundException("There is no any figure here!");
        }
        return true; // Зачем булев метод? Не проще ли сделать void?
    }

    public Figure[] getFigures() {
        return figures;
    }
}
