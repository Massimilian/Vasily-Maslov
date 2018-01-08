package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */
 
 public class BubbleSortTest {
	 @Test
	 public void whenEnterUnsortedArrayThenReturnSortedOne() {
	 BubbleSort bs = new BubbleSort();
	 int[] testArr = new int[]{2, 3, 1, 7, 13, 0, 12, 43, 15, 4, 5, 0, 21, 32, 22, 6, 9, 0, -1, -13};
	 int[] sortedTestArr = new int[]{-13, -1, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 9, 12, 13, 15, 21, 22, 32, 43};
	 testArr = bs.sort(testArr);
	 assertThat(testArr, is(sortedTestArr));
	}
 }