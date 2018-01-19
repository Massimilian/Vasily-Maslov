package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 19/01/2018
 */
 
public class Homework {
    public int[] unity(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int firstNumbers = 0;
        int secondNumbers = 0;
        int resultNumbers = 0;
        while (firstNumbers < first.length && secondNumbers < second.length) {
            if (first[firstNumbers] <= second[secondNumbers]) {
                result[resultNumbers] =  first[firstNumbers];
                firstNumbers++;
                resultNumbers++;
            } else {
                result[resultNumbers] = second[secondNumbers];
                secondNumbers++;
                resultNumbers++;
            }
        }
        if (firstNumbers < first.length) {
            for (int i = resultNumbers; i < result.length; i++) {
                result[i] = first[firstNumbers];
                firstNumbers++;
            }
        }
        if (secondNumbers < second.length) {
            for (int i = resultNumbers; i < result.length; i++) {
                result[i] = second[secondNumbers];
                secondNumbers++;
            }
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
 