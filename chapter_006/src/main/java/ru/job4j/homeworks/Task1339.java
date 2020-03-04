package ru.job4j.homeworks;

//13.39. Известен рост каждого из 25 учеников класса. Нет ни одной пары учеников, имеющих одинаковый рост. Определить:
//        а) фамилии самого высокого и самого низкого учеников класса;
//        б) фамилии двух учеников команды, являющихся самыми высокими без учета действительно самого высокого ученика класс
//        в) фамилии двух учеников команды, являющихся самыми высокими в классе,
//        не используя при этом два оператора цикла (два прохода по массиву).

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Task1339 {
    public String tallestSurname(ArrayList<Pupil138> list) {
        return this.order(list).get(0).getSurname();
    }

    public String[] twoSemitallestSurnames(ArrayList<Pupil138> list, int posOne, int posTwo) {
        String[] result;
        if (list.size() > posTwo) {
            result = new String[]{this.order(list).get(posOne).getSurname(), this.order(list).get(posTwo).getSurname()};
        } else {
            result = new String[]{};
        }
        return result;
    }


    private ArrayList<Pupil138> order(ArrayList<Pupil138> list) {
        return (ArrayList<Pupil138>) list.stream().sorted(Comparator.comparing(Pupil138::getHeight).reversed()).collect(Collectors.toList());
    }


}
