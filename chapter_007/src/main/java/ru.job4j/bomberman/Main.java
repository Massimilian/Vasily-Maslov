package ru.job4j.bomberman;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(3, 1, 1);
        Thread t = new Thread(new BomberRun(game.getBomberman(), game.getBoard()));
        t.start();
    }
}
