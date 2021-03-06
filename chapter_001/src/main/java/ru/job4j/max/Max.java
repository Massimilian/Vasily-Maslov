package ru.job4j.max;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $IId$
 * @since 03/01/2018
 */
public class Max {

	 /**
	 * to find max number of two numbers;
	 * @param two numbers;
	 * @return max number;
	 */
	
	public int max(int first, int second) {
		 return first <= second ? second : first;
		 
		 /**
		 *вариант с тремя переменными и тернарным оператором
		 *int c = (a <= b) ? b : a;
		 *return c;
		 * вариант с if, без введения дополнительной переменной
		 * if (a <= b) {
		 * return b;
		 * } else {
		 * return a;
		 */
		 }
		 
	 /**
	 * to find max number of three numbers;
	 * @param three numbers;
	 * @return max number;
	 */
	
	public int max(int first, int second, int third) {
	return max(first, second) <= max(second, third) ? max(second, third) : max(first, second);
	}
}
	