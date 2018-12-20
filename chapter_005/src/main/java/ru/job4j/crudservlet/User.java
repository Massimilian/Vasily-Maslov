package ru.job4j.crudservlet;

import java.util.Date;

public class User {
    int id;
    String name, login, email, createDate;

    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        Date date = new Date();
        this.createDate = date.toString();
    }

    @Override
    public String toString() {
        String ls = System.lineSeparator();
        return String.format("User %s:%s id = %d;%s login = %s;%s e-mail = %s;%s date of creacion: %s.",
                this.name, ls, this.id, ls, this.login, ls, this.email, ls, this.createDate);
    }
}
