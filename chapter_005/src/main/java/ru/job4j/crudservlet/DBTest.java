package ru.job4j.crudservlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBTest {
    public static void main(String[] args) {
        User user = new User(6, "Name", "Log", "mail@mailmail.ru", new Date(), null);
        User userNext = new User(6, "N", "L", "mail@mail.ru", new Date(), null);
        Store logic = DBStore.getInstance();
//        logic.add(user);
//        logic.update(userNext);
//        logic.delete(user);
//        logic.add(userNext);
        logic.deleteAll();
    }
}
