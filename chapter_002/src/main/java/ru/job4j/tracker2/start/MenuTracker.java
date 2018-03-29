package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;

class EditItem extends BaseAction implements UserAction {
	public EditItem(int key, String name) {
		super(key, name);
	}
	
	public void execute(InputSecond input, TrackerSecond tracker) {
//		String id = input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id.");
//		String name = input.ask("Введите имя. / Enter new name.");
//		String desc = input.ask("Введите описание. / Enter new description.");
//		ItemSecond item = new TaskSecond(name, desc);
//		item.setId(id);
		tracker.update(new TaskSecond(input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id."), input.ask("Введите имя. / Enter new name."), input.ask("Введите описание. / Enter new description.")));
		System.out.println("Заявка номер добавлена. / New Item added.");
	}
}

class DeleteItem extends BaseAction implements UserAction {
	public DeleteItem(int key, String name) {
		super(key, name);
	}	
	public void execute(InputSecond input, TrackerSecond tracker) {
//		String id = input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id.");
//		tracker.delete(id);
		tracker.delete(input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id."));
		System.out.println("Заявка удалена.");
	}
}

public class MenuTracker {
	private InputSecond input;
	private TrackerSecond tracker;
	private UserAction[] actions = new UserAction[7];
	private int position = 0;
	
	public MenuTracker(InputSecond input, TrackerSecond tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.actions[position++] = this.new AddItem(1, "Добавить новую заявку. / Add new Item."); // Внутренний класс
		this.actions[position++] = new MenuTracker.ShowItems(2, "Показать все заявки. / Show all items."); // Внутренний статичный класс
		this.actions[position++] = new EditItem(3, "Редактировать заявку. / Edit item."); // "Внутренний внешний класс"
		this.actions[position++] = new DeleteItem(4, "Удалить заявку. / Delete item.");  // "Внутренний внешний класс"
		this.actions[position++] = this.new FindById(5, "Найти заявку по персональному номеру. / Find item by Id."); // Внутренний класс
		this.actions[position++] = new MenuTracker.FindByName(6, "Найти заявку по имени. / Find items by name."); // Внутренний статичный класс
	}
	
	public void addAction(UserAction userAction) { // метод для профилактического использования анонимного класса
		this.actions[position++] = userAction; 
	}
	
	public void select(int key) {
		this.actions[key - 1].execute(this.input, this.tracker);
	}
	
	public void show() {
		for (UserAction action : this.actions) {
			if (action != null) {
			System.out.println(action.info());
			}
		}
	}
	
	private class AddItem extends BaseAction implements UserAction {
		public AddItem(int key, String name) {
			super(key, name);
		}
		
		public void execute(InputSecond input, TrackerSecond tracker) {
//			String name = input.ask("Введите имя новой заявки. / Enter new Task's name.");
//			String desc = input.ask("Введите описание новой заявки. / Enter new Task's description.");
//			tracker.add(new ItemSecond(name, desc));
			tracker.add(new ItemSecond(input.ask("Введите имя новой заявки. / Enter new Task's name."), input.ask("Введите описание новой заявки. / Enter new Task's description.")));
			System.out.println("Новая заявка добавлена. / New Item added.");
		}
	}
	
	private class FindById extends BaseAction implements UserAction {
		public FindById(int key, String name) {
			super(key, name);
		}
		public void execute(InputSecond input, TrackerSecond tracker) {
//			String id = input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id.");
//			ItemSecond it = tracker.findById(id);
			ItemSecond it = tracker.findById(input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id."));
			System.out.printf("Заявка с номером %s:\n Имя заявки - \"%s\",\n Описание заявки - \"%s\".\n", it.getId(), it.getName(), it.getDescription());			
		}	
	}
	
	private static class FindByName extends BaseAction implements UserAction {
		public FindByName(int key, String name) {
			super(key, name);
		}
		public void execute(InputSecond input, TrackerSecond tracker) {
//			String name = input.ask("Пожалуйста, введите имя. / Please, enter the task's name.");
			int count = 0;
//			ItemSecond[] its = tracker.findByName(name);
			ItemSecond[] its = tracker.findByName(input.ask("Пожалуйста, введите имя. / Please, enter the task's name."));
			System.out.println("Найдены следующие заявки:");
			for (ItemSecond item : its) {
				count++;
				System.out.printf("%d.\nЗаявка с номером %s:\n Описание заявки - \"%s\".\n", count, item.getId(), item.getDescription());
			}
		}
	}
	
	private static class ShowItems extends BaseAction implements UserAction {
		public ShowItems(int key, String name) {
			super(key, name);
		}
		public void execute(InputSecond input, TrackerSecond tracker) {
			for (ItemSecond item : tracker.getAll()) {
				System.out.println(String.format("%s. %s", item.getId(), item.getName()));
			}
		}
	}
}