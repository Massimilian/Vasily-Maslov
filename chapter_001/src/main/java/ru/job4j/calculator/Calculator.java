package ru.job4j.calculator;
public class Calculator {
	private double result;
	public void add(double first, double second) {
		this.result = first + second;
	}
	public void subtrack(double first, double second) {
		this.result = first - second;
	}
	public void div(double first, double second) {
		this.result = first / second;
	}
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	public double getReturn() {
	return this.result;	
	}
}