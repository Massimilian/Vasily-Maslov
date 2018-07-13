package ru.job4j.map.users;

import java.util.Calendar;

public class User extends AbstractUser{

    public User(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }
}
