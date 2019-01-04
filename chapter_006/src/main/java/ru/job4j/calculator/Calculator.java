package ru.job4j.calculator;

public class Calculator {
    private double result;
    private boolean exit = false;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtrack(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) throws SubZeroMultipleException {
        this.result = first / second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return this.result;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean getExit() {
        return this.exit;
    }
}