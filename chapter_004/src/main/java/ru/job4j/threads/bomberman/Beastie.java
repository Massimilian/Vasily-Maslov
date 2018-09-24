package ru.job4j.threads.bomberman;

public class Beastie extends Creature {

    public Beastie(int posX, int posY) {
        super(posX, posY);
    }

    public String printPosition(Cell cell) {
        return cell.getX() + " " + cell.getY();
    }
}
