package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 public class Counter {
	 int finish = 10;
	 
	 /**
	 * to find a sum of even numbers;
	 * @param start and finish numbers;
	 * @return the sum of numbers;
	 */
	
	 
	//Вариант 1, упрощённый и не очень красивый.
	public int addOne(int start, int finish) {
		int sum = 0;
		if (start % 2 != 0) {
			start++;
		}
		for (int i = start; i <= finish; i = i + 2) {
			sum = sum + i;
		}
		return sum;
	}
	
	public int addTwo(int start, int finish) {
	//Вариант 2, мне кажется - оптимальный.
		int sum = 0;
		if (start % 2 != 0) {
		start++;
		}
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
	
	public int addThree(int start, int finish) {
	// Вариант 3, для тренировки цикла foreach, использования нерекомендованного continue и разминки использования массивов.
		int sum = 0;
		if (start % 2 != 0) {
		start++;
		}
	int[] arr = new int[finish - start + 1];
	for (int i = 0; i <= finish - start; i++) {
		arr[i] = i;
		}
	for (int i : arr) {
		if (i % 2 != 0) {
			continue;
			}
		sum = sum + i + start;
		}
		return sum;
	}
 }