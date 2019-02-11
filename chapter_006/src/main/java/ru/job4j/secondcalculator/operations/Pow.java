package ru.job4j.secondcalculator.operations;

public class Pow extends Operation {

    public Pow(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return Math.pow(a, b);
    }
}
