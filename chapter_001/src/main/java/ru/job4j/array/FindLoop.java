package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 07/01/2018
 */

 public class FindLoop {
	
	 /**
	 * To find the integer;
	 * @param int[], int;
	 * @return index of discovered int;
	 */
	 
	public int indexOf(int[] data, int el) {
    int rsl = -1; // если элемента нет в массиве, то возвращаем -1.
	for (int index = 0; index < data.length; index++) {
		if (data[index] == el) {
		rsl = index;
		break;
		}
	}
	return rsl;
	}
}