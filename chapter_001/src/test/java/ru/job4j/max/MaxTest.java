package ru.job4j.max;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 31/12/2017
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {
	@Test
	public void whenFirstLessSecond() {
		Max maxim = new Max();
		int result = maxim.max(1, 2);
		assertThat(result, is(2));
	}
	
	@Test
	public void whenEnterThreeNumbersReturnMax() {
		Max maximal = new Max();
		int result = maximal.max(1, 3, 2);
		assertThat(result, is(3));
	}	
}
	