package ru.job4j.secondcalculator.operations;

public class Subtract extends Operation {
    public Subtract(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return a - b;
    }
}
