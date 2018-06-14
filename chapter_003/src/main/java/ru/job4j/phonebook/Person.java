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

    public boolean areEquals(String s) {
//        return (this.check(s, this.name) || this.check(s, this.surname) || this.check(s, this.phoneNumber) || this.check(s, this.address));
        return (this.name.contains(s) || this.surname.contains(s) || this.phoneNumber.contains(s) || this.address.contains(s));
    }

// check и другие "устаревшие" методы оставляю просто для того, чтобы потом учесть свои ошибки
    private boolean check(String str, String parameter) {
        char[] strChar = str.toCharArray();
        char[] parameterChar = parameter.toCharArray();
        boolean needToPut = false;
        if (parameterChar.length >= strChar.length) {
            for (int i = 0; i < parameterChar.length - strChar.length + 1; i++) {
                needToPut = true;
                for (int j = 0; j < strChar.length; j++) {
                    if (parameterChar[i + j] != strChar[j]) {
                        needToPut = false;
                        break;
                    }
                }
                if (needToPut) {
                    break;
                }
            }
        }
        return needToPut;
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