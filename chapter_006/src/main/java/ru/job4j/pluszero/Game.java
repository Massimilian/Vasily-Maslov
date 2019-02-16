package ru.job4j.pluszero;

import java.util.Scanner;

/**
 * The whole class of XO
 */
public class Game {
    private boolean firstWon;
    private Field f;
    private Player player;
    private Player playerTwo;

    /**
     * Constructor for initialization of the game.
     */
    public Game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Choose the size of the field:");
        int size = scanner.nextInt();
        System.out.println("Choose the size of win combination:");
        this.f = new Field(size, scanner.nextInt());
        this.player = selectPlayer("First", 'X', scanner);
        this.playerTwo = selectPlayer("Second", 'O', scanner);
        this.firstWon = false;
        System.out.println("Let's start!");
        f.showPoints();
    }

    /**
     * The main game method
     */
    public void action() {
        while (!f.isFinished()) {
            firstWon = true;
            player.makeStep(f);
            f.showPoints();
            if (!f.isFinished()) {
                firstWon = false;
                playerTwo.makeStep(f);
                f.showPoints();
            }
        }
        if (!f.checkDrawn()) {
            String winner = firstWon ? "first" : "second";
            System.out.printf("Player %s won!", winner);
        } else {
            System.out.println("Drawn game!!!");
        }
    }

    /**
     * Method to prepare the player
     * @param number
     * @param view
     * @param scan
     * @return
     */
    private Player selectPlayer(String number, char view, Scanner scan) {
        System.out.printf("Choose the type of %s player (automatic - 1, alive player - 2):%s", number, System.lineSeparator());
        return scan.nextInt() == 1 ? new AutomaticPlayer(view) : new Player(view);
    }

}
