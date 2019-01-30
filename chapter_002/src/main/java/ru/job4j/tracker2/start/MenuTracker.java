package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;
import ru.job4j.tracker2.start.interfaces.*;

import java.util.ArrayList;

class EditItem extends BaseAction implements UserAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, ITrackerStandart tracker) {
        Item fresh = new Item(input.ask("Enter new Task's name."), input.ask("Enter new Task's description."));
        fresh.setId(input.ask("Select Item by ID"));
        if (tracker.update(fresh)) {
            System.out.println("The Item updated.");
        } else {
            System.out.println("This Item can't be updated.");
        }
    }

    public void execute(Input input, ITrackerSQL tracker) {
        Item fresh = new Item(input.ask("Enter new Task's name."), input.ask("Enter new Task's description."));
        fresh.setId(input.ask("Select Item by ID"));
        if (tracker.update(fresh)) {
            System.out.println("The Item updated.");
        } else {
            System.out.println("This Item can't be updated.");
        }
    }
}

class DeleteItem extends BaseAction implements UserAction {
    public DeleteItem(int key, String name) {
        super(key, name);
    }

    public void execute(Input input, ITrackerStandart tracker) {
        tracker.delete(input.ask("Please, enter the task's id."));
        System.out.println("This task has been deleted");
    }

    public void execute(Input input, ITrackerSQL tracker) {
        tracker.delete(input.ask("Please, enter the task's id."));
        System.out.println("This task has been deleted");
    }
}

public class MenuTracker {
    private Input input;
    private ITracker tracker;
    private UserAction[] actions = new UserAction[8];
    private int position = 0;

    public MenuTracker(Input input, ITracker tracker) {
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

    public void select(int key, boolean isSql) {
        if (!isSql) {
            if (key == 0) {
                this.actions[7].execute(this.input, (ITrackerStandart) this.tracker);
            } else {
                this.actions[key - 1].execute(this.input, (ITrackerStandart) this.tracker);
            }
        } else {
            if (key == 0) {
                this.actions[7].execute(this.input, (ITrackerSQL) this.tracker);
            } else {
                this.actions[key - 1].execute(this.input, (ITrackerSQL) this.tracker);
            }
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

        public void execute(Input input, ITrackerStandart tracker) {
            tracker.add(new Item(input.ask("Enter new Task's name."), input.ask("Enter new Task's description.")));
            System.out.println("New Item added.");
        }

        public void execute(Input input, ITrackerSQL tracker) {
            tracker.add(new Item(input.ask("Enter new Task's name."), input.ask("Enter new Task's description.")));
            System.out.println("New Item added.");
        }
    }

    private class FindById extends BaseAction implements UserAction {
        public FindById(int key, String name) {
            super(key, name);
        }

        //			For standart tracker (not SQL):
        public void execute(Input input, ITrackerStandart tracker) {
            Item it = tracker.findById(input.ask("Please, enter the task's id."));
            System.out.printf("Task's number - %s:\n Task's name - \"%s\",\n Task's description \"%s\".\n", it.getId(), it.getName(), it.getDescription());
        }

        public void execute(Input input, ITrackerSQL tracker) {
            tracker.findByIdSQL(input.ask("Please, enter the task's id."));
        }
    }

    private static class FindByName extends BaseAction implements UserAction {
        public FindByName(int key, String name) {
            super(key, name);
        }

        //			For standart tracker (not SQL):
        public void execute(Input input, ITrackerStandart tracker) {
            int count = 0;
            ArrayList<Item> its = tracker.findByName(input.ask("Please, enter the task's name."));
            System.out.println("Task's founded:");
            for (Item item : its) {
                count++;
                System.out.printf("%d.\n Task's number %s:\n Task's description - \"%s\".\n", count, item.getId(), item.getDescription());
            }
        }

        public void execute(Input input, ITrackerSQL tracker) {
            tracker.findByNameSQL(input.ask("Please, enter the task's name."));
        }
    }

    private static class ShowItems extends BaseAction implements UserAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        //			Method for standart tracker:
        public void execute(Input input, ITrackerStandart tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s", item.getId(), item.getName()));
            }
        }

        public void execute(Input input, ITrackerSQL tracker) {
            tracker.getAllwithSQL();
        }
    }

    public boolean setIsSQL() {
        return this.tracker instanceof TrackerSQL;
    }
}