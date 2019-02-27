package ru.job4j.pluszero;

/**
 * Class for make the playing place.
 */
public class Field {
    private char[][] points;
    private final int winsize;
    private int round = 0;
    private boolean isFinished = false;

    public Field(int size, int winSize) {
        points = prepareField(size);
        this.winsize = winSize;
    }

    public int getSize() {
        return this.points.length;
    }

    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Method for preparing this field for playing
     *
     * @param size
     * @return prepared field
     */
    private char[][] prepareField(int size) {
        char[][] points = new char[size][size];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                points[i][j] = '*';
            }
        }
        return points;
    }

    /**
     * Method to show the number of round
     */
    public void showPoints() {
        System.out.printf("Round №%d%s", this.round, System.lineSeparator());
        for (int i = 0; i < this.points.length; i++) {
            for (int j = 0; j < this.points[i].length; j++) {
                System.out.print(points[i][j]);
            }
            System.out.println();
        }
        System.out.println("_______");
    }

    /**
     * Method to put X or O on its place.
     *
     * @param step
     * @param view
     */
    public void getStep(int[] step, char view) {
        if (points[step[0] - 1][step[1] - 1] == '*') {
            points[step[0] - 1][step[1] - 1] = view;
        } else {
            System.out.println("Wrong step! You've lost your turn!");
        }
        this.checkFinish();
        this.round++;
    }

    /**
     * Method to look the status of game (finished or no)
     */
    public void checkFinish() {
        if (checkDrawn()) {
            isFinished = true;
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (this.isFinished) {
                    break;
                }
                if (points[i][j] != '*') {
                    if (j <= points.length - winsize) {
                        this.isFinished = checkBoard(i, j, 0, 1);
                    }
                    if (this.isFinished) {
                        break;
                    }
                    if (i <= points.length - winsize) {
                        this.isFinished = checkBoard(i, j, 1, 0);
                        if (this.isFinished) {
                            break;
                        }
                        if (j <= points.length - winsize) {
                            this.isFinished = checkBoard(i, j, 1, 1);
                        }
                        if (this.isFinished) {
                            break;
                        }
                        if (j >= winsize - 1) {
                            this.isFinished = checkBoard(i, j, 1, -1);
                        }
                        if (this.isFinished) {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Method to answer is this a drawn game of no.
     *
     * @return
     */
    public boolean checkDrawn() {
        boolean check = true;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                check = points[i][j] != '*';
                if (!check) {
                    break;
                }
            }
            if (!check) {
                break;
            }
        }
        return check;
    }

    /**
     * Check positions as win session.
     *
     * @param x
     * @param y
     * @return
     */
    private boolean checkBoard(int x, int y, int plusX, int plusY) {
        int newPlusX = plusX;
        int newPlusY = plusY;
        boolean equal = true;
        for (int i = 0; i < this.winsize - 1; i++) {
            equal = this.points[x][y] == this.points[x + newPlusX][y + newPlusY];
            if (!equal) {
                break;
            }
            newPlusY += plusY;
            newPlusX += plusX;
        }
        return equal;
    }
}
