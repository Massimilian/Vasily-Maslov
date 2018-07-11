package ru.job4j.map.Users;

import java.util.Calendar;
import java.util.Objects;

public class User extends AbstractUser{

    public User(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }
}
