package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 07/01/2018
 */
 
 public class SquareTest {
	 public void whenEnterANumberThenReturnAllNumbersFromOneToNumber() {
		 Square sq = new Square();
		 int[] result = sq.calculate(3);
		 int[] expectedresult = new int[]{1, 4, 9};
		 assertThat(result, is(expectedresult));
	 }
 }
 