package ru.job4j.threads.bomberman;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    final private ReentrantLock[][] board;
    final private int size;
    private Heroe heroe;
    final private Beastie[] beastiarium;

    public Heroe getHeroe() {
        return heroe;
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }

    public Beastie getBeastie(int number) {
        return beastiarium[number];
    }

    public int getSize() {
        return size;
    }

    public Board(int size, int startPosX, int startPosY, int numberOfBlocks, int numberOfBeasties) {
        // создаём бомбермена согласно указанному в конструкторе положению. Внимание - бомбермен НЕ блокирует клетку.
        heroe = new Heroe(startPosX, startPosY);
        // инициализируем поле согласно указанному в конструкторе размеру. Все поля пока открыты (unlocked)
        this.size = size;
        board = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        // создаём блоки, количество которых задаётся в конструкторе
        Cell[] blocks = new Cell[numberOfBlocks];
        // надо ли дорабатывать условие, что блоков может быть >= 4, а, соответственно, они могут заблокировать главного героя?
        Random random = new Random();
        for (int i = 0; i < numberOfBlocks; i++) {
            do {
                blocks[i] = new Cell();
                blocks[i].setX(random.nextInt(size));
                blocks[i].setY(random.nextInt(size));
            }
            while (board[blocks[i].getX()][blocks[i].getY()].isLocked() || blocks[i].getX() == startPosX && blocks[i].getY() == startPosY);
            // если блок не попадает на занятую клетку, то он блокирует клетку.
            // Если клетка уже занята или там бомбермен - пробуем ещё раз назначить место блока
            board[blocks[i].getX()][blocks[i].getY()].tryLock();
        }
        // создаём бестиариум (массив чудовищ)
        beastiarium = new Beastie[numberOfBeasties];
        for (int i = 0; i < numberOfBeasties; i++) {
            int x;
            int y;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (board[x][y].isLocked() || x == startPosX && y == startPosY);
            // если поле для предполагаемого чудовища не занято или там нет бомбермена, то создаём на этом поле чудовище
            beastiarium[i] = new Beastie(x, y);
            // блокируем поле для чудовища
            board[beastiarium[i].getPosition().getX()][beastiarium[i].getPosition().getY()].tryLock();
        }
    }

    private boolean toLock(Cell cell) {
        // блокируем ячейку
        return board[cell.getX()][cell.getY()].tryLock();
    }

    private void toUnlock(Cell cell) {
        // почему-то нижеследующая строчка выкидывает IllegalMonitorStateException.
        // Несколько раз проверил - ячейка заблокирована, всё нормально.
        // Пришлось действовать альтернативным вариантом - решить вопрос через try-catch
        try {
            board[cell.getX()][cell.getY()].unlock();
        } catch (IllegalMonitorStateException imse) {
            board[cell.getX()][cell.getY()] = new ReentrantLock();
        }
    }

    private boolean isLocked(Cell cell) {
        // проверяем, заблокирована ли ячейка
        return board[cell.getX()][cell.getY()].isLocked();
    }

    public boolean move(Cell source, Cell dist) {
        boolean result = false;
        // проверяем - не заблокирована ли клетка назначения, если нет - хватаем блок
        if (this.toLock(dist)) {
            // проверяем - заблокирована ли клетка отправления
            if (this.isLocked(source)) {
                // если заблокирована - разблокируем
                this.toUnlock(source);
            }
            result = true;
        }
        return result;
    }
}
