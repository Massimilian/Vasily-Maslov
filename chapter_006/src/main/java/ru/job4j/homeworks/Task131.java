package ru.job4j.homeworks;

//13.1. Фамилии и имена 25 учеников класса записаны в двух различных таблицах.
//        Напечатать фамилию и имя каждого ученика на отдельной строке.

import java.util.List;

public class Task131 {
    public void print(List<String> a, List<String> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            System.out.printf("%s, %s.%s", a.get(i), b.get(i), System.lineSeparator());
        }
    }
}
