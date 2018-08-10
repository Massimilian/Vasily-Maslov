package ru.job4j.homeworks.simpletasks;

//        Реализовать класс квадрат основанный на четырех точках Point(x, y).
//        boolean exists() - проверяет существует ли квадрат или нет.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Task6 {
    Task2 one;
    Task2 two;
    Task2 three;
    Task2 four;

    public Task6(Task2 one, Task2 two, Task2 three, Task2 four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        if (!exists()) {
            throw new IllegalStateException();
        }
    }

    public boolean exists() {
        boolean result = true;
        Set<Task2> points = new HashSet<>();
        points.add(one);
        points.add(two);
        points.add(three);
        points.add(four);
        if (points.size() != 4) {
            result = false;
        } else {
            Set<Double> checkingSizes = new HashSet<>();
            checkingSizes.add(one.pointDistanceTo(two));
            checkingSizes.add(one.pointDistanceTo(three));
            checkingSizes.add(one.pointDistanceTo(four));
            checkingSizes.add(two.pointDistanceTo(three));
            checkingSizes.add(two.pointDistanceTo(four));
            checkingSizes.add(three.pointDistanceTo(four));
            if (checkingSizes.size() != 2) {
                result = false;
            } else {
                Iterator<Double> it = checkingSizes.iterator();
                double one = it.next();
                double two = it.next();
                if (Math.pow(one, 2) != Math.pow(two, 2) * 2 || Math.pow(two, 2) != Math.pow(one, 2) * 2) {
                    result = false;
                }
            }
        }
        return result;
    }
}
