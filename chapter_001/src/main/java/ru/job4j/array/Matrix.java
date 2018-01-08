package ru.job4j.array;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 09/01/2018
 */

 public class Matrix {
	 int[][] multiple(int size) {
		 size++; // наверняка пользователь захочет получить таблицу до того номера ВКЛЮЧИТЕЛЬНО, который укажет во входных параметрах
		 int[][] mult = new int[size][size]; 
		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				 mult[i][j] = i * j;
			 }
		 }
		 return mult;
	 }
 }