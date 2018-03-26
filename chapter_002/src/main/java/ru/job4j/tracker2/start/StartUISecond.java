package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;

public class StartUISecond {
	private int[] ranges = {1, 2, 3, 4, 5, 6, 7};
	private InputSecond input;
	private TrackerSecond tracker = new TrackerSecond();
	public StartUISecond(InputSecond input) {
		this.input = input;
	}
	
	public StartUISecond(InputSecond input, TrackerSecond tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void init() {
		MenuTracker menu = new MenuTracker(this.input, this.tracker);
		menu.fillActions();
		boolean cont = true;
		do {
			menu.show();
			System.out.println("");
			menu.select(input.ask("Выберите меню: / Select:", ranges));
			System.out.println("");
		} while (cont);
//		} while (!"n".equals(this.input.ask("Хотите продолжить (y/n)? / Do you want to continue (y/n)?")));
	}
	
	public static void main(String[] args) {
		InputSecond input = new ValidateInput();
		new StartUISecond(input).init();
	}
}