package ru.job4j.lambda.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Method for verify winner X
     *
     * @return is the winner X
     */
    public boolean isWinnerX() {
        return this.crutching(Figure3T::hasMarkX);
    }

    /**
     * Method for verify winner O
     *
     * @return is the winner Y
     */
    public boolean isWinnerO() {
        return this.crutching(Figure3T::hasMarkO);
    }

    /**
     * Method for verify having empty fields
     *
     * @return have the field
     */
    public boolean hasGap() {
        return !(Arrays.stream(table).flatMap(Arrays::stream).noneMatch(f -> !f.hasMarkO() && !f.hasMarkX()));
    }

    /**
     * Method for verify all posible winner positions
     *
     * @param predicate who we check
     * @return is the winner
     */
    private boolean crutching(Predicate<Figure3T> predicate) {
        return this.crutch(predicate, 0, 0, 1, 0) || this.crutch(predicate, 1, 0, 0, 1) || this.fillBy(predicate, 0, 0, 1, 1) || this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Method to verify winner multiposition
     *
     * @param predicate choosing symbol
     * @param startX    position x
     * @param startY    position y
     * @param deltaX    step x
     * @param deltaY    step y
     * @return has winner position
     */
    private boolean crutch(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = false;
        if (deltaY == 0) {
            for (int i = 0; i < table.length; i++) {
                if (this.fillBy(predicate, startX, i, deltaX, deltaY)) {
                    result = true;
                    break;
                }
            }
        }
        if (deltaX == 0 || !result) {
            for (int i = 0; i < table.length; i++) {
                if (this.fillBy(predicate, i, startY, deltaX, deltaY)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Method to verify having one winner position.
     *
     * @param predicate choosing symbol
     * @param startX    position x
     * @param startY    position y
     * @param deltaX    step x
     * @param deltaY    step y
     * @return is winner position
     */
    private boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
}



