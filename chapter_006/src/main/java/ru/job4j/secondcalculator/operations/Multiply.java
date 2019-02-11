package ru.job4j.secondcalculator.operations;

public class Multiply extends Operation {
    public Multiply(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return a * b;
    }
}
