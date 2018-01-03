package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 public class Factorial {
	 public int calc(int max) {
		int tempMax = 1;
		if (max >= 13) {
		// System.out.println("Число слишком большое!");
		return -1;
		} else if (max == 0) {
		return 1;
		}
		for (int i = 1; i <= max; i++) {
		tempMax = tempMax * i;	
		}
		return tempMax;
	 }
 }