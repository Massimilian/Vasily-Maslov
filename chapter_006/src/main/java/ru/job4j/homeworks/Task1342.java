package ru.job4j.homeworks;

//13.42. Известно расписание поездов, проходящих через станцию: номер поезда, назначение
//        (откуда куда, например, Москва — Омск), часы и минуты прибытия, часы и минуты отправления.
//        Значения часов и минут целые, положительные; число часов не превышает 23, число минут — 59.
//        Общее число проходящих поездов равно 25. Поезда приходят каждый день.
//        По данному времени определить, какие поезда (номер и назначение) стоят в этот момент на станции.

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Task1342 {
    public ArrayList<Train1342> getTrains(ArrayList<Train1342> trains, Time1342 time) {
        return (ArrayList<Train1342>) trains.stream().filter((a) -> time.getHour() >= a.getStart().getHour() && time.getHour() <= a.getEnd().getHour() && time.getMinute() >= a.getStart().getMinute() && time.getMinute() <= a.getEnd().getMinute()).collect(Collectors.toList());
    }
}
