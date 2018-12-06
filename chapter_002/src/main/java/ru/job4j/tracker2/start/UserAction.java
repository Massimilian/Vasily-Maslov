package ru.job4j.tracker2.start;

public interface UserAction {
	int key();
	void execute(InputSecond input, Tracker tracker);
	String info();
}