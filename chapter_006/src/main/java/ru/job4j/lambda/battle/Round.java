package ru.job4j.lambda.battle;

public class Round {
    private int round = 0;

    public void upgrade() {
        round++;
    }

    public String getRound() {
        return String.format("%s №%d.%s", "Round", round, System.lineSeparator());
    }
}
