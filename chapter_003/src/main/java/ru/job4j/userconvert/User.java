package ru.job4j.userconvert;

import java.util.Random;

public class User {
    private int id;
    private String city;
    private String name;

    public User(String name, String city) {
        Random random = new Random();
        this.id = random.nextInt();
        this.city = city;
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
