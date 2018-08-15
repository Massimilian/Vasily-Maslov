package ru.job4j.homeworks.simpletasks.task19;

// Задан двойной массив из единиц и нулей.
// Нужно найти минимальный путь от точки А до точки В.
// Двигаться можно только по единицам и только по вертикали или горизонтали.

import java.util.ArrayList;

public class Task19 {
    private int[][] array;
    private Point19 start;
    private Point19 finish;
    private boolean hasFinish;

    public int[][] findExit(int[][] array, int startPosX, int startPosY, int finPosX, int finPosY) {
        this.hasFinish = false;
        this.array = array;
        int count = 0;
        this.start = new Point19(startPosX, startPosY);
        this.finish = new Point19(finPosX, finPosY);
        ArrayList<TheWay> ways = new ArrayList<>();
        ways.add(new TheWay(start));
        while (!hasFinish && count < 10000000) {
            ways = this.tryGo(ways, count);
            count++;
        }
        if (count >= 10000000) {
            throw new IllegalStateException();
        }
        this.array[startPosX][startPosY] = 1;
        int[][] result = new int[this.array.length][this.array.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = 0;
            }
        }

        result[finPosX][finPosY] = count + 1;
        for (int i = count; i >= 0; i--) {
            if (finPosX > 0 && this.array[finPosX - 1][finPosY] == i) {
                finPosX--;
                result[finPosX][finPosY] = i;
            } else if (finPosX < result.length - 1 && this.array[finPosX + 1][finPosY] == i) {
                finPosX++;
                result[finPosX][finPosY] = i;
            } else if (finPosY > 0 && this.array[finPosX][finPosY - 1] == i) {
                finPosY--;
                result[finPosX][finPosY] = i;
            } else if (finPosY < result.length - 1 && this.array[finPosX][finPosY + 1] == i) {
                finPosY++;
                result[finPosX][finPosY] = i;
            }
        }

        return result;
    }


    private ArrayList<TheWay> tryGo(ArrayList<TheWay> ways, int count) {
        Point19 temp = ways.get(0).getLast();
        if (temp.getX() > 0) {
            Point19 newPoint = new Point19(temp.getX() - 1, temp.getY());
            this.changes(ways, newPoint, count);
        }
        if (temp.getX() < this.array.length - 1) {
            Point19 newPoint = new Point19(temp.getX() + 1, temp.getY());
            this.changes(ways, newPoint, count);
        }
        if (temp.getY() > 0) {
            Point19 newPoint = new Point19(temp.getX(), temp.getY() - 1);
            this.changes(ways, newPoint, count);
        }
        if (temp.getY() < this.array.length - 1) {
            Point19 newPoint = new Point19(temp.getX(), temp.getY() + 1);
            this.changes(ways, newPoint, count);
        }
        return ways;
    }

    private ArrayList<TheWay> changes(ArrayList<TheWay> ways, Point19 newPoint, int count) {
        if (array[newPoint.getX()][newPoint.getY()] == (char) 1) {
            newPoint.setQueue(count + 1);
            TheWay tempWay = new TheWay(ways.get(0).getAllWay());
            tempWay.add(newPoint);
            ways.add(tempWay);
            this.array[newPoint.getX()][newPoint.getY()] = count + 2;
            if (newPoint.equals(this.finish)) {
                hasFinish = true;
            }
        }
        return ways;
    }
}
