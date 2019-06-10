package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {
    public void multiple(int start, int finish, int value, BiFunction<Integer, Integer, Double> op, Consumer<Double> media) {
        for (int i = start; i <= finish; i++) {
            media.accept(op.apply(value, i));
        }
    }

    public static double add(int left, int second) {
        return left + second;
    }

    public static double div(int left, int second) {
        return left / second;
    }
}
