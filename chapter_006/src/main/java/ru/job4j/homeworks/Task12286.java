package ru.job4j.homeworks;
//12.286.*Шахматную доску будем представлять в виде квадратного символьного массива
//        размером 8 8. Даны натуральные числа v1 и g1 , указывающие номера верти-
//        кали (при счете слева направо) и горизонтали (при счете снизу вверх) для поля,
//        на котором стоит белая шахматная фигура, и числа v2 и g2 — указывающие
//        соответствующие координаты второй, черной, фигуры ( 1 v1 8, 1 g1 8,
//        1 v2 8, 1 g2 8 ). Определить поля (отметить их символом "+"), на которые
//        может пойти первая фигура, не попав под удар второй фигуры. Рассмотреть сле-
//        дующие варианты сочетаний первой и второй фигур:
//        а) ладья и ладья;
//        б) ладья и ферзь;
//        в) ладья и конь;
//        г) ладья и слон;
//        д) ферзь и ферзь;
//        е) ферзь и ладья;
//        ж) ферзь и конь;
//        з) ферзь и слон;
//        и) конь и конь;
//        к) конь и ладья;
//        л) конь и ферзь;
//        м) конь и слон;
//        н) слон и слон;
//        о) слон и ферзь;
//        п) слон и конь;
//        р) слон и ладья;
//        с) король и слон;
//        т) король и ферзь;
//        у) король и конь;
//        ф) король и ладья.

import ru.job4j.homeworks.task12285.Figure;
import ru.job4j.homeworks.task12285.Task12285;

public class Task12286 {
    private Task12285 helper = new Task12285();
    private char[][] preparedOne = new char[8][8];
    private char[][] preparedTwo = new char[8][8];

    public Task12286() {
        this.renovate(preparedOne);
        this.renovate(preparedTwo);
    }

    public char[][] safePositions(Figure figOne, Figure figTwo) {
        preparedOne = helper.figureAttack(preparedOne, figOne);
        preparedTwo = helper.figureAttack(preparedTwo, figTwo);
        for (int i = 0; i < preparedOne.length; i++) {
            for (int j = 0; j < preparedTwo.length; j++) {
                if (preparedOne[i][j] == '*' && String.valueOf(preparedTwo[i][j]).matches("[A-Z]")) {
                    preparedOne[i][j] = '@';
                }
                if (preparedOne[i][j] == '*' && preparedTwo[i][j] != '*') {
                    preparedOne[i][j] = '+';
                }
            }
        }
        return preparedOne;
    }

    private void renovate(char[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = '0';
            }
        }
    }
}
