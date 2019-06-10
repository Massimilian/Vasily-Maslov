package ru.job4j.lambda;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 3,
                (value, index) -> {
                    System.out.printf("Multiple %s * %s = ", value, index);
                    return (double) value * index;
                },
                result -> System.out.printf("%f%s", result, System.lineSeparator())
        );
    }
}
