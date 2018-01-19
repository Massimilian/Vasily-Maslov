package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 10/01/2018
 */
 
 public class HomeworkTest {
	 @Test
	 public void whenEnterTwoSortedArraysThenReturnOneBigSortedArray() {
		 Homework hw = new Homework();
		 int[] testingArrayOne = {0, 2, 4};
		 int[] testingArrayTwo = {0, 1, 3};
		 int[] test = hw.unity(testingArrayOne, testingArrayTwo);
		 int[] result = {0, 0, 1, 2, 3, 4};
		 assertThat(test, is(result));
	 }
	 
	 @Test
	 public void whenEnterTwoSortedArraysThenReturnOneBigSortedArrayEasyWay() {
		 Homework hw = new Homework();
		 int[] testingArrayOne = {0, 2, 4, 5};
		 int[] testingArrayTwo = {0, 1, 3};
		 int[] test = hw.easyUnity(testingArrayOne, testingArrayTwo);
		 int[] result = {0, 0, 1, 2, 3, 4, 5};
		 assertThat(test, is(result));
	 }
 }