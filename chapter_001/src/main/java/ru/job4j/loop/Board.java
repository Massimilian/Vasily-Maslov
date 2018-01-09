package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 public class Board {
	 
	 /**
	 * to get chess board
	 * @param width&height;
	 * @return filled board with "x" and " ";
	 */
	
	 public String paint(int width, int height) {
		StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i <= (width - 1); i++) {
            for (int j = 0; j <= (height - 1); j++) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
			// а почему нельзя вместо ввода переменной ln типа String прописать таким образом: 
            // screen.append(System.lineSeparator);
			screen.append(ln);
        }
        return screen.toString();
    }
}