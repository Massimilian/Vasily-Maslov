package ru.job4j.tracker2.start;

import ru.job4j.tracker2.start.interfaces.Input;

public class StubInput extends ConsoleInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, int[] range) {
//		throw new UnsupportedOperationException("Unsupported operation");
//		return -1;
        return Integer.parseInt(answers[position++]);
    }
}