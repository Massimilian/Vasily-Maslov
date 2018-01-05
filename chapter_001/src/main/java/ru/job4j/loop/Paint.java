package ru.job4j.loop;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $IId$
 * @since 06/01/2018
 */

import java.util.function.BiPredicate;
 
 public class Paint {
    public String rightTrl(int height) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте. 
        int weight = height; 
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != weight; column++) {
                // если строка равна ячейки, то рисуем галку. 
                // в данном случае строка определяем, сколько галок будет на строке
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }
	public String leftTrl(int height) {
    StringBuilder screen = new StringBuilder();
    int weight = height;
    for (int row = 0; row != height; row++) {
        for (int column = 0; column != weight; column++) {
            if (row >= weight - column - 1) {
                screen.append("^");
            } else {
                screen.append(" ");
            }
        }
        screen.append(System.lineSeparator());
    }
    return screen.toString();
	}
	public String pyramid(int height) {
    StringBuilder screen = new StringBuilder();
    int weight = 2 * height - 1;
    for (int row = 0; row != height; row++) {
        for (int column = 0; column != weight; column++) {
            if (row >= height - column - 1 && row >= column - height + 1) {
                screen.append("^");
            } else {
                screen.append(" ");
            }
        }
        screen.append(System.lineSeparator());
    }
    return screen.toString();
	}
	
	// тот же код, только после рефакторинга
	
	public String rightTriangle(int height) {
    return this.loopBy(height, height, (row, column) -> row >= column);
	}
	
	public String leftTriangle(int height) {
    return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }
	
	private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
    StringBuilder screen = new StringBuilder();
    for (int row = 0; row != height; row++) {
        for (int column = 0; column != weight; column++) {
            if (predict.test(row, column)) {
                screen.append("^");
            } else {
                screen.append(" ");
            }
        }
        screen.append(System.lineSeparator());
    }
    return screen.toString();
	}
}