package ru.job4j.map.Users;

import java.util.Calendar;

public abstract class AbstractUser {
    String name;
    int children;
    Calendar birthday;

    public AbstractUser(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
