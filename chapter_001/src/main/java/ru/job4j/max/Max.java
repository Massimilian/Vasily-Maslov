package ru.job4j.max;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 31/12/2017
 */
public class Max {
	 /**
     * Ищет максимальное число
     * @param два числа.
     * @return максимальное число.
     */
	 public int max(int a, int b) {
		 int c = (a <= b) ? b : a;
		 return c;
		 /** вариант с if, без введения дополнительной переменной
		 * if (a <= b) {
		 * return b;
		 * } else {
		 * return a;
		 */
		 }
	 }
	 