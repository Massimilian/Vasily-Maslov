package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 10/01/2018
 */
 
 public class ArrayDuplicateTest {
	 @Test
	 public void whenGetDuplicateArrayThenReturnThisArrayWithoutDuplicates() {
		 ArrayDuplicate arr = new ArrayDuplicate();
		 String[] test = {"One", "Two", "Two", "Three", "Three", "Three", "One", "Two", "Four", "Three", "One"};
		 test = arr.remove(test);
		 String[] result = {"One", "Two", "Three", "Four"};
		 assertThat(test, arrayContainingInAnyOrder(result));
	 }
	 
	 @Test
	 public void whenGetDuplicateArrayThenReturnThisArrayWithoutDuplicatesNewWay() {
		 ArrayDuplicate arr = new ArrayDuplicate();
		 String[] test = {"One", "Two", "Two", "Three", "Three", "Three", "One", "Two", "Four", "Three", "One"};
		 test = arr.removeAnotherWay(test);
		 String[] result = {"One", "Two", "Three", "Four"};
		 assertThat(test, is(result));
	 }
 }