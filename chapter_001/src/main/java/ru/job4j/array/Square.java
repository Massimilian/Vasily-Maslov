package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 07/01/2018
 */

 public class Square {
	 	 
	 /**
	 * Pows;
	 * @param number of cells;
	 * @return matrix with pows;
	 */
	 
	public int[] calculate(int bound) {
	int[] rsl = new int[bound];
    // заполнить массив через цикл элементами от 1 до bound возведенные в квадрат
	for (int i = 1; i <= bound; i++) {
		rsl[(i - 1)] = (int) Math.pow(i, 2);
		}
    return rsl;
	}
 }