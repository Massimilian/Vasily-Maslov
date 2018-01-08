
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */
 

 public class TurnTest {
	 @Test
	 public void whenEnterAnArrayThenReturnTurnedArray() {
		 Turn turn = new Turn();
		 int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
		 test = turn.back(test);
		 int[] turnedTest = new int[]{7, 6, 5, 4, 3, 2, 1};
		 assertThat(test, is(turnedTest));
	 }
 }
