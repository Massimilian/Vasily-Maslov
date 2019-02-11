package ru.job4j.secondcalculator.operations;

/**
 * Operations of SimpleCalculator
 */
public abstract class Operation {
    String sign;

    public Operation(String sign) {
        this.sign = sign;
    }

    /**
     * Main action of SimpleCalculator
     *
     * @param a
     * @param b
     * @return result of operation
     */
    public abstract double function(double a, double b);

    /**
     * Method, that helps to choose the Operation
     */
    public String getSign() {
        return sign;
    }
}
