package ru.job4j.homeworks.task12282;

import java.util.ArrayList;

public abstract class Figure {
    final Position pos;

    public Figure(Position pos) {
        this.pos = pos;
    }

    public Position getPos() {
        return pos;
    }

    public abstract ArrayList<Position> move(int squareX, int squareY);
}
