package ru.job4j.phonebook;

public class Person {
    private String name;
    private String surname;
    private String phoneNumber;
    private String address;

    public Person(String name, String surname, String phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return String.format("%s %s %s %s", this.getName(), this.getSurname(), this.getPhoneNumber(), this.getAddress());
    }
}