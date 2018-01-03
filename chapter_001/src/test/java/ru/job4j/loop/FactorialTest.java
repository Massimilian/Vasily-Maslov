package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
	@Test
	public void whenEnterNumberThenReturnFactorialOfTheNumberInIntegerFormat() {
		Factorial fact = new Factorial();
		int result = fact.calc(5);
		assertThat(result, is(120));
	}
	
	@Test
	public void whenEnterTooBigNumberThenReturnMinusOne() {
		Factorial fact = new Factorial();
		int result = fact.calc(1234);
		assertThat(result, is(-1));
	}
	
	@Test
	public void whenEnterZeroThenReturnFactorialOfZeroInIntegerFormat() {
		Factorial fact = new Factorial();
		int result = fact.calc(0);
		assertThat(result, is(1));
	}
}