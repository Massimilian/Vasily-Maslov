package ru.job4j.chess;

import ru.job4j.chess.figures.*;
import ru.job4j.chess.exceptions.*;

public class Board {
    int count = 0;
    Figure[] figures = new Figure[32];

    void add(Figure figure) {
        boolean canSet = true;
        if (count >= figures.length) {
            canSet = false;
        }
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                break;
            }
            if (figure.getPosition().equals(figures[i].getPosition())) {
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
        boolean haveFigure = false;
        for (int i = 0; i < this.count; i++) {
            if (this.figures[i].getPosition().equals(source)) {
                haveFigure = true;
                this.figures[i].copy(dest);
                break;
            }
            if (!haveFigure) {
                throw new FigureNotFoundException("There is no any figure here!");
            }
        }
        for (int i = 0; i < this.count; i++) {
            if (this.figures[i].getPosition().equals(dest)) {
                throw new OccupiedWayException("This cell is busy!");
            }
        }
        return true; // Зачем булев метод? Не проще ли сделать void?
    }
}
