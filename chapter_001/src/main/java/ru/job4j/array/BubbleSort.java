package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */

 public class BubbleSort {
	 public int[] sort(int[] array) {
	 for (int i = 0; i < array.length - 1; i++) {
		 for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					array[j] = array[j] + array[j + 1];
					array[j + 1] = array[j] - array[j + 1];
					array[j] = array[j] - array[j + 1];
				}
			}
		}
		return array;
	}
}

