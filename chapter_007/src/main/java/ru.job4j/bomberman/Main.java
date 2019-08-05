package ru.job4j.bomberman;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {
        int size = 10; // the field size
        int numbOfStones = 2; // number of stones on the field
        int numberOfBestias = 5; // number of bestias.
        Game game = new Game(size, numbOfStones, numberOfBestias);
        Thread hero = new Thread(new BombermanRun(game.getBomberman(), game.getBoard()));
        // all threads except Bomberman's thread are not important, because if Bomberman is out, the game is over. That is why all these threads are daemon threads.
        ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setDaemon(true);
                return t;
            }
        });
        for (int i = 0; i < game.getBestias().length; i++) {
            exec.execute(new BeastiaRun(game.getBestias()[i], game.getBoard()));
        }
        hero.start();
        boolean isNotFinish = false;
        // waiting the end of the game
        while (!isNotFinish) {
            isNotFinish = game.getBomberman().isEaten();
            game.toCont();
        }
    }
}
