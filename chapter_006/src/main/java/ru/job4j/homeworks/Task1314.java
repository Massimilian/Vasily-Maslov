package ru.job4j.homeworks;

//13.14. Известна информация о 25 моментах времени одних и тех же суток: часы (значения от 0 до 23) и минуты (от 0 до 59).
// Составить программу, сравнивающую два любых момента времени по их условному порядковому номеру
// (определяющую, какой из моментов был в эти сутки раньше).

import java.util.ArrayList;

public class Task1314 {
    public Moment1314 earlier(ArrayList<Moment1314> times, int one, int two) {
        Moment1314 result = new Moment1314();
        if (times.get(one).getHour() == times.get(two).getHour()) {
            result = times.get(one).getMinute() > times.get(two).getMinute() ? times.get(two) : times.get(one);
        } else {
            result = times.get(one).getHour() > times.get(two).getHour() ? times.get(two) : times.get(one);
        }
        return result;
    }
}
