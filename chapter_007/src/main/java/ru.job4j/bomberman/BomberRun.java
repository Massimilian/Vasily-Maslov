package ru.job4j.bomberman;

public class BomberRun extends CreatureRun {
    public BomberRun(Creature creature, Board board) {
        super(creature, board);
    }

    @Override
    public void run() {
        board.setCreature(creature.getCell());
        while (true) {
            Cell temp = new Cell(creature.getCell());
            System.out.printf("Bomberman's position is %s %s. %s", temp.getPosX(), temp.getPosY(), System.lineSeparator());
            creature.move();
            if (board.tryCell(creature.getCell())) {
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