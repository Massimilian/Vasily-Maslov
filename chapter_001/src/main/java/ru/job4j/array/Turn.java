/**
package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

*/

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 08/01/2018
 */
 
 /**
 public class Turn {
	 public int[] back(int[] array) {
		 // {1, 2, 3, 4, 5}
		 // {5, 4, 3, 2, 1}
		 
		 // 4, 5
		 // 4 = 4+5; x = x+y
		 // 5 = 4(9)-5; y = x-y
		 // 4 = 4(9) - 5(4); x = x-y;
		 
		 for (int i = 0; i < array.length / 2; i++) {
		 array[i] = array[i] + array[array.length - i];
		 array[array.length - i] = array[i] - array[array.length - i];
		 arrai[i] =  array[i] - array[array.length - i];
		 }
		 return array;
	 }
 }
 */