package ru.job4j.bomberman;

/**
 * Method for move the resident of Bestiarium
 */
public class BeastiaRun extends CreatureRun {
    public BeastiaRun(Creature creature, Board board) {
        super(creature, board);
    }

    @Override
    public void run() {
        while (true) {
            this.go();
        }
    }

    /**
     * Special method to try to move the creature.
     */
    @Override
    protected void go() {
        Cell temp = new Cell(creature.getCell());
        System.out.printf("%s's position is %s %s. %s", creature.getName(), temp.getPosX(), temp.getPosY(), System.lineSeparator());
        creature.move(this.board.getBoardSize(), board.getStones());
        if (board.tryCell(creature.getCell())) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else { // if the creature meet another creature
            System.out.printf("%s stopped.%s", creature.getName(), System.lineSeparator());
            creature.setCell(temp);
            Thread.yield();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}