package ru.job4j.homeworks;

//13.52.* Известен рост каждого из 25 учеников класса.
//        Нет ни одной пары учеников, имеющих одинаковый рост.
//        Вывести фамилии учеников в порядке возрастания их роста.

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Task1352 {
    public ArrayList<String> getNames(Map<String, Integer> pupils) {
        return (ArrayList<String>) pupils.keySet().stream().sorted().collect(Collectors.toList());
    }
}
