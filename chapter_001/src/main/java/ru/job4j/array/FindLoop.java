package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 07/01/2018
 */

 public class FindLoop {
	public int indexOf(int[] data, int el) {
	int index = 0;
    int rsl = -1; // если элемента нет в массиве, то возвращаем -1.
	for (int i: data) {
		if (data[index] == el) {
		rsl = index;
		break;
		}
		index++;
	}
	return rsl;
	}
}