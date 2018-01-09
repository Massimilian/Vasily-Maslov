package ru.job4j.calculator;
public class Calculator {
	private double result;
		 	 	 
	 /**
	 * to get sum;
	 * @param double&double;
	 * @return sum of doubles;
	 */
	 
	public void add(double first, double second) {
		this.result = first + second;
	}

	 /**
	 * to get minus;
	 * @param double&double;
	 * @return double minus double;
	 */
	 
	public void subtrack(double first, double second) {
		this.result = first - second;
	}
	
	 /**
	 * to get separation;
	 * @param double&double;
	 * @return result of separation of two doubles;
	 */
	
	public void div(double first, double second) {
		this.result = first / second;
	}
	
	
	 /**
	 * to get multiplication;
	 * @param double&double;
	 * @return result of multiplication of two doubles;
	 */
	
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	
	public double getResult() {
	return this.result;	
	}
}