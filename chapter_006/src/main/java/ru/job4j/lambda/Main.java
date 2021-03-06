package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

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

        calc.multiple(1, 5, 2,
                Calculator::add,
                result -> System.out.println(result)
        );
    }
}
