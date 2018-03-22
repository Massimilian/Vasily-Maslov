package ru.job4j.tracker2.start;

import java.util.*;

public class ConsoleInputSecond implements InputSecond {
	private Scanner scanner = new Scanner(System.in);
	
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
	
}