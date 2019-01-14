package ru.job4j.compositecalc;

public class EngennerCalculatorForComposite {

    /**
     * Find percent.
     *
     * @param first  - number.
     * @param second - number of percents.
     */
    public double percent(double first, double second) {
        return first / 100 * second;
    }

    /**
     * Make pow operation.
     *
     * @param first
     * @param second
     */
    public double pow(double first, double second) {
        return Math.pow(first, second);
    }
}
