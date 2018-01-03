package ru.job4j.condition;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 31/12/2017
 */
 
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PointTest {
	 @Test
	 public void whenOnePointEqualSecondPointThenReturnZero() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 1);
		double result = 0D;
		assertThat(a.distanceTo(b), is(result));
	 }
}
