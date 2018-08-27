package ru.job4j.homeworks.simpletasks.task19;

import ru.job4j.homeworks.simpletasks.task19.Point19;

import java.util.ArrayList;

public class TheWay {
    boolean isFinished = false;
    private ArrayList<Point19> allWay = new ArrayList<>();

    public TheWay(Point19 placeNow) {
        allWay.add(placeNow);
    }

    public TheWay(ArrayList<Point19> allWay) {
        this.allWay = allWay;
    }

    public Point19 getLast() {
        return allWay.get(allWay.size() - 1);
    }

    public void add(Point19 newPoint) {
        allWay.add(newPoint);
    }

    public ArrayList<Point19> getAllWay() {
        return allWay;
    }
}


