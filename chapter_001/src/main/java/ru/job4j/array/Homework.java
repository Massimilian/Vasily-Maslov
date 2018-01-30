package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $IId$
 * @since 27/01/2018
 */
 
public class Homework {
    public int[] unity(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstNumbers = 0;
        int secondNumbers = 0;
        int resultNumbers = 0;
        while (firstNumbers < first.length && secondNumbers < second.length) {
			result[resultNumbers] = first[firstNumbers] <= second[secondNumbers] ? first[firstNumbers] : second[secondNumbers];
			resultNumbers++;
            if (first[firstNumbers] <= second[secondNumbers]) {
                firstNumbers++;
            } else {
                secondNumbers++;
			}
        }
        if (firstNumbers < first.length) {
			System.arraycopy(first, firstNumbers, result, result.length - first.length + firstNumbers, first.length - firstNumbers);
        }
        if (secondNumbers < second.length) {
			System.arraycopy(second, secondNumbers, result, result.length - second.length + secondNumbers, second.length - secondNumbers);
        }
        return result;
    }

	
	public int[] easyUnity(int[] first, int[] second) {
		int[] result = new int[first.length + second.length];
		for (int i = 0; i < first.length; i++) {		
			result[i] = first[i];
		}
		for (int i = 0; i < second.length; i++) {
			result [first.length + i] = second[i];
		}
		Arrays.sort(result);
		return result;
	}
}
 