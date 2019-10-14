package ru.job4j.homeworks;

//13.8. Известны данные о 25 учениках класса: фамилия, имя, отчество, адрес и домашний телефон, если он есть.
// Вывести на экран фамилию, имя и адрес учеников, у которых нет домашнего телефона. Рассмотреть два случая:
//        1) телефон задан в виде семизначного числа;
//        2) телефон задан в виде, аналогичном следующему: 268–50–59.

import java.util.ArrayList;

public class Task138 {
    public void withoutPhones(ArrayList<Pupil138> pupils) {
        for (int i = 0; i < pupils.size(); i++) {
            if (pupils.get(i).getNumber() == 0) {
                System.out.println(String.format("Name: %s %s; address: %s.", pupils.get(i).getName(), pupils.get(i).getSurname(), pupils.get(i).getAddress()));
            }
        }
    }
}
