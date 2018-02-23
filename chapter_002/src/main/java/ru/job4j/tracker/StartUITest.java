package ru.job4j.tracker;

public class StartUITest {
	public static void main(String[] args) {
	Input input = new StubInput(new String[]{"0", "TestItem", "TestDescription"});
    new StartUI(input).init();
    }
}