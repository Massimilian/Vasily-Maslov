package ru.job4j.homeworks;

public class Pupil138 {
    String surname;
    String name;
    String address;
    int number = 0;

    public Pupil138(String surname, String name, String address, int number) {
        this.surname = surname;
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public Pupil138(String surname, String name, String address) {
        this.surname = surname;
        this.name = name;
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNumber() {
        return number;
    }
}
