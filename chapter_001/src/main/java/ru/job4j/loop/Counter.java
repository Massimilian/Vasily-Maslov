package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 public class Counter {
	 int finish = 10;
	//Вариант 1, упрощённый и не очень красивый.
	public int addOne() {
		int sum = 0;
		for (int i = 0; i <= finish; i = i + 2) {
			sum = sum + i;
		}
		return sum;
	}
	
	public int addTwo() {
	//Вариант 2, мне кажется - оптимальный.
		int sum = 0;
		for (int i = 0; i <= finish; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
	
	public int addThree() {
	// Вариант 3, для тренировки цикла foreach, использования нерекомендованного continue и разминки использования массивов.
	int sum = 0;
	int[] arr = new int[finish + 1];
	for (int i = 0; i <= finish; i++) {
		arr[i] = i;
		}
	for (int i : arr) {
		if (i % 2 != 0) {
			continue;
			}
		sum = sum + i;
		}
		return sum;
	}
 }