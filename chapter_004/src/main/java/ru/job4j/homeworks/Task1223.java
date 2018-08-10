package ru.job4j.homeworks;

//12.23.  Заполнить двумерный массив размером 7 7 так, как показано на рисунке:

//      #1
//      1000001
//      0100010
//      0010100
//      0001000
//      0010100
//      0100010
//      1000001

//      #2
//      1001001
//      0101010
//      0011100
//      1001001
//      0011100
//      0101010
//      1001001

//      #3
//      1111111
//      0111110
//      0011100
//      0001000
//      0011100
//      0111110
//      1111111

public class Task1223 {
    private int[][] paint;

    public Task1223(int size) {
        paint = new int[size][size];
    }

    public int[][] firstPaint(int backGround, int colorado) {
        int color = 0;
        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint.length; j++) {
                if (j == color || j == paint.length - 1 - color) {
                    this.paint[i][j] = colorado;
                } else {
                    this.paint[i][j] = backGround;
                }
            }
            color++;
        }
        return paint;
    }


    public int[][] secondPaint(int backGround, int colorado) {
        int color = 0;
        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint.length; j++) {
                if (j == color || j == paint.length - 1 - color || j == paint.length / 2) {
                    this.paint[i][j] = colorado;
                } else {
                    if (i == paint.length / 2 && j == 0 || i == paint.length / 2 && j == paint.length - 1) {
                        this.paint[i][j] = colorado;
                    } else {
                        this.paint[i][j] = backGround;
                    }
                }
            }
            color++;
        }
        return paint;
    }

    public int[][] thirdPaint(int backGround, int colorado) {
        int color = 0;
        boolean mustChanged = false;
        for (int i = 0; i < paint.length; i++) {
            for (int j = 0; j < paint.length; j++) {
                if (color == 0) {
                    paint[i][j] = colorado;
                    continue;
                }
                if (j >= paint.length - color || j <= color - 1) {
                    paint[i][j] = backGround;
                } else {
                    paint[i][j] = colorado;
                }
            }

            if (!mustChanged) {
                if (color == paint.length / 2) {
                    mustChanged = true;
                    color--;
                } else {
                    color++;
                }
            } else {
                color--;
            }
        }
        return paint;
    }
}
