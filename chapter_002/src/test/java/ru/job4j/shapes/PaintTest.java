package ru.job4j.shapes;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 01/03/2018
 */
 
 public class PaintTest {
	 @Test
	 public void whenAskTriangleThenPaintTriangle() {
		 Shape triangle = new Triangle();
		 assertThat(triangle.draw(), is(new StringBuilder().append("  *  ").append(" *** ").append("*****").toString()));
	 }
	 
	 @Test
	 public void whenAskSquareThenPaintSquare() {
		 Shape square = new Square();
		 assertThat(square.draw(), is(new StringBuilder().append("***").append("* *").append("***").toString()));
	 }
	 
	     @Test
    public void whenDrawSquare() {
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфeр для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в память для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушие в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(new String(out.toByteArray()), is(new StringBuilder().append("***").append("* *").append("***").toString()));
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }
}