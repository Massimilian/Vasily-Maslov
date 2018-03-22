package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;

class EditItem implements UserAction {
	public int key() {
		return 3;
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
	
	public String info() {
		return String.format("%s. %s", this.key(), "Редактировать заявку. / Edit item.");
	}
}

class DeleteItem implements UserAction {
	public int key() {
		return 4;
	}
	
	public void execute(InputSecond input, TrackerSecond tracker) {
//		String id = input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id.");
//		tracker.delete(id);
		tracker.delete(input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id."));
		System.out.println("Заявка удалена.");
	}
	
	public String info() {
		return String.format("%s. %s", this.key(), "Удалить заявку. / Delete item.");
	}
}

public class MenuTracker {
	private InputSecond input;
	private TrackerSecond tracker;
	private UserAction[] actions = new UserAction[7];
	
	public MenuTracker(InputSecond input, TrackerSecond tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.actions[0] = this.new AddItem();
		this.actions[1] = new MenuTracker.ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = new DeleteItem();
		this.actions[4] = this.new FindById();
		this.actions[5] = new MenuTracker.FindByName();
		this.actions[6] = new MenuTracker.Exit();
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
	
	private class AddItem implements UserAction {
		public int key() {
			return 1;
		}
		
		public void execute(InputSecond input, TrackerSecond tracker) {
//			String name = input.ask("Введите имя новой заявки. / Enter new Task's name.");
//			String desc = input.ask("Введите описание новой заявки. / Enter new Task's description.");
//			tracker.add(new ItemSecond(name, desc));
			tracker.add(new ItemSecond(input.ask("Введите имя новой заявки. / Enter new Task's name."), input.ask("Введите описание новой заявки. / Enter new Task's description.")));
			System.out.println("Новая заявка добавлена. / New Item added.");
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Добавить новую заявку. / Add new Item.");
		}
	}
	
	private class FindById implements UserAction {
		public int key() {
			return 5;
		}
		
		public void execute(InputSecond input, TrackerSecond tracker) {
//			String id = input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id.");
//			ItemSecond it = tracker.findById(id);
			ItemSecond it = tracker.findById(input.ask("Пожалуйста, введите персональный номер заявки. / Please, enter the task's id."));
			System.out.printf("Заявка с номером %s:\n Имя заявки - \"%s\",\n Описание заявки - \"%s\".\n", it.getId(), it.getName(), it.getDescription());			
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Найти заявку по персональному номеру. / Find item by Id.");
		}
	
	
	}
	private static class FindByName implements UserAction {
		public int key() {
			return 6;
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
		
		public String info() {
			return String.format("%s. %s", this.key(), "Найти заявку по имени. / Find items by name.");
		}
	}
	
	private static class ShowItems implements UserAction {
		public int key() {
			return 2;
		}
		
		public void execute(InputSecond input, TrackerSecond tracker) {
			for (ItemSecond item : tracker.getAll()) {
				System.out.println(String.format("%s. %s", item.getId(), item.getName()));
			}
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Показать все заявки. / Show all items.");
		}
	}
	
	private static class Exit implements UserAction {
		public int key() {
			return 7;
		}
		
		public void execute(InputSecond input, TrackerSecond tracker) {
			if ("y".equals(input.ask("Вы действительно хотите выйти? / Do you want to exit?"))) {
				System.exit(0);
			}
		}
		
		public String info() {
			return String.format("%s, %s", this.key(), "Выход из Программы. / Exit Program.");
		}
	}
}