package ru.job4j.bomberman;

public class BomberRun extends CreatureRun {
    public BomberRun(Creature creature, Board board) {
        super(creature, board);
    }

    @Override
    public void run() {
        board.getBoard()[creature.getCell().getPosX()][creature.getCell().getPosY()].lock();
        while (true) {
            Cell temp = new Cell(creature.getCell().getPosX(), creature.getCell().getPosY());
            System.out.printf("Bomberman's position is %s %s. %s", temp.getPosX(), temp.getPosY(), System.lineSeparator());
            creature.move();
            if (board.getBoard()[creature.getCell().getPosX()][creature.getCell().getPosY()].tryLock()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.printf("Bomberman stopped.%s", System.lineSeparator());
                creature.setCell(temp);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}