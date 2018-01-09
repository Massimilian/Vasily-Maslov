package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */
 
 
 public class Turn {
	 	 	 
	 /**
	 * Turn array;
	 * @param array;
	 * @return turned array;
	 */

	 public int[] back(int[] array) {		 
		for (int i = 0; i < array.length / 2; i++) {
		array[i] = array[i] + array[array.length - 1 - i];
		array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
		array[i] = array[i] - array[array.length - 1 - i];
		}
		return array;
	 }
 }
 