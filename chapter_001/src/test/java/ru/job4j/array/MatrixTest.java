package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 09/01/2018
 */
 
 public class MatrixTest {
	 @Test
	 public void whenEnterTheMatrixLengthThenReturnTheMatrixWithThisSize() {
		 Matrix mat = new Matrix();
		 int[][] test = mat.multiple(2);
		 int[][] result = {{0, 0, 0}, {0, 1, 2}, {0, 2, 4}};
		 assertThat(test, is(result));
	 }
 }