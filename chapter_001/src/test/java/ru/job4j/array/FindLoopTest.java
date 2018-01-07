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
	 public void whenEnterANumberThenReturnItsPlace() {
		 FindLoop fl = new FindLoop();
		 int[] test = new int[10];
		 test[3] = 4;
		 int result = fl.indexOf(test, 3);
		 assertThat(result, is(4));
	 }
	 
	 public void whenEnterImpossibleNumberThenReturnMenosOne() {
		FindLoop fl = new FindLoop();
		int[] test = new int[10];
		int result = fl.indexOf(test, 11);
		assertThat(result, is(-1));
	 }
	 
 }