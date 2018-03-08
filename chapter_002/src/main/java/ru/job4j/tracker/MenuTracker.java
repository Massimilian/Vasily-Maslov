package ru.job4j.tracker;

public class MenuTracker { // внешний класс
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[5]; // массив тех действий, которые мы собираемся предпринимать
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() { // метод для инициализации событий
		this.actions[0] = new AddItem(this.input, this.tracker);
	}
	
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			System.out.println(action.info());
		}
	}
	
	private class AddItem implements UserAction { // внутренний нестатический класс
	public int key() {
		return 1;
		}
	
	public void execute(Input input, Tracker tracker) {
		String itemName = input.ask("Пожалуйста, введите имя заявки: / Please, enter the task's name:");
		String itemDesc = input.ask("Пожалуйста, введите описание заявки: / Please, enter the task's description:");
		tracker.add(new Item(itemName, itemDesc));
		}

	public String info() {
		return String.format("%s. %s", this.key(), "Добавить заявку. / Add new item.");
		}
	}
}