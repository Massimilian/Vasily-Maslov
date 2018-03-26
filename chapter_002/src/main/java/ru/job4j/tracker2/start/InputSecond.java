package ru.job4j.tracker2.start;

public interface InputSecond {
	
	String ask(String question);
	int ask(String question, int[] range); // overloading
}