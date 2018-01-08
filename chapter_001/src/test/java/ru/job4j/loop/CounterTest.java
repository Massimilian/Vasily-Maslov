package ru.job4j.loop;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 04/01/2018
 */
 
 
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
 
 public class CounterTest {
	 @Test
	 public void whenEnterTenNumbersThenTheSumOfEvenReturnsFirstTry() {
		 Counter cont = new Counter();
		 int result = cont.addOne(3, 15);
		 assertThat(result, is(54));
	 }
	 
	 @Test
	 public void whenEnterTenNumbersThenTheSumOfEvenReturnsSecondTry() {
		 Counter cont = new Counter();
		 int result = cont.addTwo(0, 10);
		 assertThat(result, is(30));
	 }
	 
	 @Test
	 public void whenEnterTenNumbersThenTheSumOfEvenReturnsThirdTry() {
		 Counter cont = new Counter();
		 int result = cont.addThree(1, 13);
		 assertThat(result, is(42));
	 }
 }