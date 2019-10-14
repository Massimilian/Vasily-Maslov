package ru.job4j.bomberman;

/**
 * Class of running creature (bomberman), that not blocks the cells.
 */
public class BombermanRun extends CreatureRun {
    private String separator = " $$$ ";

    public BombermanRun(Creature creature, Board board) {
        super(creature, board);
    }

    @Override
    public void run() {
        while (!creature.isEaten()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.go();
        }
        System.out.printf("%s%s has been eaten!%s%s", this.separator, creature.getName(), this.separator, System.lineSeparator());
    }

    @Override
    protected void go() {
        creature.move(this.board.getBoardSize(), board.getStones());
        System.out.printf("%s%s moved at %s %s. %s%s", this.separator, creature.getName(), creature.getCell().getPosX(), creature.getCell().getPosY(), this.separator, System.lineSeparator());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
