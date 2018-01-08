package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */
 
 
 public class Turn {
	 public int[] back(int[] array) {
		 // {1, 2, 3, 4, 5}
		 // {5, 4, 3, 2, 1}
		 
		 for (int i = 0; i < array.length / 2; i++) {
		 array[i] = array[i] + array[array.length - 1 - i];
		 array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
		 array[i] = array[i] - array[array.length - 1 - i];
		 }
		 return array;
	 }
 }
 