package ru.job4j.array;
import java.util.Arrays;

// В видео есть "пошаговая инструкция". Просмотрел один раз и попытался воспроизвести по памяти.
// P.S. Больше всего (больше часа) бился над второй строкой.

/**
 * @author Petr Arsentev (parsentev@yandex.ru) / Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 0.1
 */

 
 public class ArrayDuplicate {
	 public String[] remove(String[] array) {
	 int numberOfNotDuplicates = array.length;
	 for (int i = 0; i < numberOfNotDuplicates; i++) {
		 for (int j = i + 1; j < numberOfNotDuplicates; j++) {
			 if (array[i].equals(array[j])) {
				 numberOfNotDuplicates--;
				 array[j] = array[numberOfNotDuplicates];
				 j--;
				}
			}
		}
		return Arrays.copyOf(array, numberOfNotDuplicates);
	}

	
// А можно ли сделать то же самое, но таким образом?
// Подозреваю, что способ более "тяжёлый". У него два преимущества - 
// не меняет порядок ячеек и придуман мною ДО просмотра видео с "пошаговой инструкцией".

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 10/01/2018
 */


	public String[] removeAnotherWay(String[] array) {
		int duplicates = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == null) {
				continue;
			}
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].equals(array[j])) {
				array[j] = null;
				duplicates++;
				}				
			}
		}
		int count = 0;
		String[] backArray = new String[array.length];
		for (int i = 0; i < backArray.length; i++) {
			if (array[i] != null) {
				backArray[i - count] = array[i];
			} else {
				count++;
			}
		}
		duplicates = array.length - duplicates;
		return Arrays.copyOf(backArray, duplicates);
	}
 }
 