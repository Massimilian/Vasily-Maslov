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
		UserAction exit = new UserAction() { // анонимный класс
			public int key() {
			return 7;
			}
		public void execute(InputSecond input, TrackerSecond tracker) {
			if ("y".equals(input.ask("Вы действительно хотите выйти? / Do you want to exit?"))) {
				System.exit(0);
				}
			}
		public String info() {
			return String.format("%s . %s", this.key(), "Выход из Программы. / Exit Program.");
			}
		};
		
		menu.addAction(exit);
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
		InputSecond input = new ValidateInput(new ConsoleInputSecond());
		new StartUISecond(input).init();
	}
}