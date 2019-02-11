package ru.job4j.secondcalculator.operations;

public class Divide extends Operation {
    public Divide(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return a / b;
    }
}
