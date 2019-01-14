package ru.job4j.compositecalc;

import ru.job4j.calculator.SubZeroMultipleException;

public class CalculatorForComposite {

    public double add(double first, double second) {
        return first + second;
    }

    public double subtrack(double first, double second) {
        return first - second;
    }

    public double div(double first, double second) throws SubZeroMultipleException {
        return first / second;
    }

    public double multiple(double first, double second) {
        return first * second;
    }
}