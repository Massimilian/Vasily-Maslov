package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 07/01/2018
 */
 
 public class FindLoopTest {
	 @Test
	 public void whenEnterANumberThenReturnItsPlace() {
		 FindLoop fl = new FindLoop();
		 int[] test = new int[]{1, 2, 3, 7, 4, 5, 6, 7, 8, 9};
		 int result = fl.indexOf(test, 7);
		 assertThat(result, is(3));
	 }
	 
	 @Test
	 public void whenEnterImpossibleNumberThenReturnMenosOne() {
		FindLoop fl = new FindLoop();
		int[] test = new int[10];
		for (int i = 0; i < test.length; i++) {
			test[i] = i;
			}
		int result = fl.indexOf(test, 10);
		assertThat(result, is(-1));
	 }
	
 }