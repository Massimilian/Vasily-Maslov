package ru.job4j.bomberman;

import java.util.Random;

/**
 * Class for collect and prepare all components of game together.
 */
public class Game extends Thread {
    private Random random = new Random();
    private final Board board;
    private final Creature bomberman;
    private final Creature[] bestiarium;
    private String[] bestNames = {"Beast", "Begemoth", "Creature", "Horror", "Monster", "Fear", "Dread", "Terror", "Fobos", "Deimos"};

    public Game(int size, int numbOfStones, int numberOfBesties) {
        bomberman = new Bomberman(0, 0, "Bomberman");
        board = new Board(size, numbOfStones);
        bestiarium = this.prepareZoo(numberOfBesties);
    }

    /**
     * Method to prepare Bestiarium
     *
     * @param num of Bestias
     * @return ready Bestiarium
     */
    private Creature[] prepareZoo(int num) {
        Creature[] bestiarium = new Creature[num];
        for (int i = 0; i < num; i++) {
            bestiarium[i] = new Bestia(this.board, bestNames[random.nextInt(bestNames.length)]);
            this.board.reserved(bestiarium[i].getCell());
        }
        return bestiarium;
    }

    public Board getBoard() {
        return this.board;
    }

    public Creature getBomberman() {
        return this.bomberman;
    }

    public Creature[] getBestias() {
        return this.bestiarium;
    }

    /**
     * Method to check is Bomberman and any Bestia are together (and one of them is eaten)
     */
    public void toCont() {
        if (board.getBoard()[bomberman.getCell().getPosX()][bomberman.getCell().getPosY()].isLocked()) {
            bomberman.setEaten(true);
        }
    }
}
