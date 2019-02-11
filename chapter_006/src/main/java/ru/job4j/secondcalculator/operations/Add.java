package ru.job4j.secondcalculator.operations;

public class Add extends Operation {

    public Add(String sign) {
        super(sign);
    }

    @Override
    public double function(double a, double b) {
        return a + b;
    }
}
