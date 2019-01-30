package ru.job4j.tracker2.start;

import ru.job4j.tracker2.start.interfaces.Input;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final ConsoleInput input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data again.");
            } catch (MenuOutException moe) {
                System.out.println("Please select correct menu.");
            }
        } while (invalid);
        return value;
    }
}