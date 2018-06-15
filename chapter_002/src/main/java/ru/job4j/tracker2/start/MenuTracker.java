package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;

import java.util.ArrayList;

class EditItem extends BaseAction implements UserAction {
	public EditItem(int key, String name) {
		super(key, name);
	}
	
	public void execute(InputSecond input, TrackerSecond tracker) {
		tracker.update(new TaskSecond(input.ask("Please, enter the task's id."), input.ask("Enter new name."), input.ask("Enter new description.")));
		System.out.println("New Item added.");
	}
}

class DeleteItem extends BaseAction implements UserAction {
	public DeleteItem(int key, String name) {
		super(key, name);
	}	
	public void execute(InputSecond input, TrackerSecond tracker) {
		tracker.delete(input.ask("Please, enter the task's id."));
		System.out.println("This task has been deleted");
	}
}

public class MenuTracker {
	private InputSecond input;
	private TrackerSecond tracker;
	private UserAction[] actions = new UserAction[8];
	private int position = 0;
	
	public MenuTracker(InputSecond input, TrackerSecond tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		this.actions[position++] = this.new AddItem(1, "Add new Item."); // Внутренний класс
		this.actions[position++] = new MenuTracker.ShowItems(2, "Show all items."); // Внутренний статичный класс
		this.actions[position++] = new EditItem(3, "Edit item."); // "Внутренний внешний класс"
		this.actions[position++] = new DeleteItem(4, "Delete item.");  // "Внутренний внешний класс"
		this.actions[position++] = this.new FindById(5, "Find item by Id."); // Внутренний класс
		this.actions[position++] = new MenuTracker.FindByName(6, "Find items by name."); // Внутренний статичный класс
	}
	
	public void addAction(UserAction userAction) { // метод для профилактического использования анонимного класса
		this.actions[position++] = userAction; 
	}
	
    public void select(int key) {
        if (key == 0) {
         this.actions[7].execute(this.input, this.tracker);
        } else {
            this.actions[key - 1].execute(this.input, this.tracker);
        }
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
		tracker.add(new ItemSecond(input.ask("Enter new Task's name."), input.ask("Enter new Task's description.")));
		System.out.println("New Item added.");
		}
	}
	
	private class FindById extends BaseAction implements UserAction {
		public FindById(int key, String name) {
			super(key, name);
		}
		public void execute(InputSecond input, TrackerSecond tracker) {
			ItemSecond it = tracker.findById(input.ask("Please, enter the task's id."));
			System.out.printf("Task's number - %s:\n Task's name - \"%s\",\n Task's description \"%s\".\n", it.getId(), it.getName(), it.getDescription());			
		}	
	}
	
	private static class FindByName extends BaseAction implements UserAction {
		public FindByName(int key, String name) {
			super(key, name);
		}
		public void execute(InputSecond input, TrackerSecond tracker) {
			int count = 0;
			ArrayList<ItemSecond> its = tracker.findByName(input.ask("Please, enter the task's name."));
			System.out.println("Task's founded:");
			for (ItemSecond item : its) {
				count++;
				System.out.printf("%d.\n Task's number %s:\n Task's description - \"%s\".\n", count, item.getId(), item.getDescription());
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