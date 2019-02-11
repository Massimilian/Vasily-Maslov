package ru.job4j.secondcalculator.operations;

public class Percent extends Operation {

    public Percent(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return a / 100 * b;
    }
}
