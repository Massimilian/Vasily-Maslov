package ru.job4j.homeworks.simpletasks;

//Задан квадратный массив.
// Нужно проверить, что в нем есть выигрышные варианты для игры крестики-нолики.

public class Task16 {
    public boolean hasWinner(int[][] array, int win) {
        boolean result = false;
        if (this.lookLines(array, win) || this.lookLines(this.makeCircleArray(array), win)
                || this.lookDiagonal(array, win) || this.lookDiagonal(this.makeCircleArray(array), win)) {
            result = true;
        }
        return result;
    }

    private int[][] makeCircleArray(int[][] array) {
        int[][] newArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                newArray[j][i] = array[i][j];
            }
        }
        return newArray;
    }

    private boolean lookLines(int[][] lines, int howMuch) {
        boolean isWin = false;
        int count;
        for (int[] line : lines) {
            count = 0;
            for (int j = 0; j < line.length - 1; j++) {
                count = line[j] == line[j + 1] ? count + 1 : 0;
                if (count == howMuch - 1) {
                    isWin = true;
                    break;
                }
            }
        }
        return isWin;
    }

    private boolean lookDiagonal(int[][] diagonales, int howMuch) {
        boolean isWin = false;
        int count;
        for (int i = 0; i < diagonales.length - howMuch; i++) {
            for (int j = 0; j < diagonales[i].length - howMuch; j++) {
                count = 0;
                for (int k = 0; k < howMuch - 1; k++) {
                    count = diagonales[i + k][j + k] == diagonales[i + k + 1][j + k + 1] ? count + 1 : 0;
                    if (count == howMuch - 1) {
                        isWin = true;
                        break;
                    }
                }
            }
        }
        return isWin;
    }
}