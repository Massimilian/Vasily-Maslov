package ru.job4j.tracker2.start;

public interface UserAction {
	int key();
	void execute(InputSecond input, TrackerSecond tracker);
	String info();
}