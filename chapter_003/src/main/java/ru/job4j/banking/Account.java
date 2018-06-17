package ru.job4j.banking;

import java.util.Random;

public class Account {
    private double value;
    private String requisites;

    public Account() {
        this.value = 0;
    }

    public Account(String requisites) {
        this.value = 0;
        this.requisites = requisites;
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

}
