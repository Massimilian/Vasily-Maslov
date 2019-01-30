package ru.job4j.tracker2.start.interfaces;

public interface Input {

    String ask(String question);

    int ask(String question, int[] range); // overloading
}