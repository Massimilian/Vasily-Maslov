package ru.job4j.tracker;

public interface UserAction {
	int key(); // ключ, по которому будет доступен метод по запросу
	void execute(Input input, Tracker tracker); // выполнение собственно метода
	String info(); // вывод информации
}