package ru.job4j.threads.bomberman;

public class Main {
    public static void main(String[] args) {
        // инициализируем размер поля
        int boardSize = 10;
        // инициализируем количество чудовищ
        int numberOfBeasties = 3;
        // устанавлваем скорость чудовищ (от 1 до 99)
        int beastieSpeed = 50;
        // устанавливаем количество блоков
        int howMuchBlocks = 4;
        // инициализируем стартовую позицию Бомбермена
        int bombermanStartPosX = 3;
        int bombermanStartPosY = 2;
        // инициализируем поле
        Board board = new Board(boardSize, bombermanStartPosX, bombermanStartPosY, howMuchBlocks, numberOfBeasties);
        // создаём условия окончания игры
        boolean isFinish = false;
        // запускаем чудовищ
        for (int i = 0; i < numberOfBeasties; i++) {
            Thread thread = new Thread(new BeastieAction(i, board, beastieSpeed));
            thread.setDaemon(true);
            thread.start();
        }

        while (!isFinish) {
            // здесь можно было бы реализовать движение через Callable,
            // когда каждый шаг возвращает в виде новой позиции, динамически обновляющейся.
            // В задании указано, что пользовательский ввод реализовывать не надо,
            // так что Бомбермен просто ждёт, когда его съедят.
            if (board.getBoard()[board.getHeroe().getPosition().getX()][board.getHeroe().getPosition().getY()].isLocked()) {
                System.out.println("The hero was eaten!");
                isFinish = true;
            }
        }
    }
}
