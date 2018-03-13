package ru.job4j.tracker1.start;

import ru.job4j.tracker1.models.*;

public class StartUI {
	private Input input;
	private boolean exit = false;
	private String answer;
	private Tracker tracker = new Tracker();
	
	public StartUI(Input input) {
		this.input = input;
	}
	
	public StartUI(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
		
	public void init() {
		while (!exit) {
			this.showMenu();
			answer = this.input.ask("Введите пункт меню. / Enter menu number.");
			System.out.println();
			if (answer.equals("1")) {
				String name = this.input.ask("Введите имя новой заявки. / Enter new Task's name.");
				String desc = this.input.ask("Введите описание новой заявки. / Enter new Task's description.");
				tracker.add(tracker.createNewItem(name, desc));
				System.out.printf("Заявка с персональным номером \"%s\" успешно добавлена! / The new Task with id-number \"%s\" successfully added! \n", tracker.findByName(name)[0].getId(), tracker.findByName(name)[0].getId());
			} else if (answer.equals("2")) {
				String id = this.input.ask("Введите персональный номер заявки. / Enter the Task's id-number.");
				String name = this.input.ask("Введите новое имя заявки. / Enter new name.");
				String desc = this.input.ask("Введите новое описание заявки. / Enter new description.");
				tracker.replace(id, new Item(name, desc));
				System.out.printf("Заявка с персональным номером \"%s\" успешно изменена! / The new Task with id-number \"%s\" successfully added! \n", tracker.findByName(name)[0].getId(), tracker.findByName(name)[0].getId());				
			} else if (answer.equals("3")) {
				String id = this.input.ask("Введите персональный номер заявки, которую Вы хотите удалить. / Enter the Task's id-number, which you want to delete.");
				System.out.printf("Заявка под именем \"%s\" успешно удалена! / The Task named \"%s\" successfully deleted! \n", id, id);
				tracker.delete(id);				
			} else if (answer.equals("4")) {
				for (Item item : tracker.findAll()) {
					System.out.println(item.getName() + "; " + item.getDescription());
				}
			} else if (answer.equals("5")) {
				String name = this.input.ask("Введите имя заявки. / Enter the name.");
				int count = 1;
					for (Item item : tracker.findByName(name)) {
					System.out.printf("Заявка №%d:\nИмя заявки: \"%s\"\nОписание заявки: \"%s\"\nПерсональный номер: \"%s\"\n\n", count++, item.getName(), item.getDescription(), item.getId());
					System.out.println("--------------------");
					System.out.printf("Task №%d:\nTask's name: \"%s\"\nTask's description: \"%s\"\nTask's id-number: \"%s\"\n\n\n\n", count++, item.getName(), item.getDescription(), item.getId());
				}
			} else if (answer.equals("6")) {
				String id = this.input.ask("Введите персональный номер заявки. / Enter the Task's id-number.");
				System.out.printf("Заявка с персональным номером %s:\n Имя - \"%s\".\nОписание - \"%s\".\n", id, tracker.findById(id).getName(), tracker.findById(id).getDescription());
				System.out.println("--------------------");
				System.out.printf("The Task with personal id-number %s:\n Name - \"%s\".\nDescription - \"%s\".\n\n\n", id, tracker.findById(id).getName(), tracker.findById(id).getDescription());
			} else {
				System.out.println("Непредвиденная ошибка. / ERROR!");
			}
			String cont = this.input.ask("Хотите продолжить (y/n)? / Do you want to continue (y/n)?");
			if (cont.equals("n") || cont.equals("т")) {
				System.out.println("Спасибо за пользование программой! / Thank you for using this app!");
				this.exit = true;
			}
		}
	}
	
	private void showMenu() {
		System.out.printf("---МЕНЮ--- \n1.\tДобавить новую заявку. / Add new Task.\n2.\tПоменять заявку. / Change Task.\n3\tУдалить заявку. / Delete Task.\n4\tНапечатать имеющиеся заявки. / Print all Tasks.\n5\tНайти заявку по имени. / Find the Task by name.\n6\tНайти заявку по персональному номеру. / Find The Task by personal id-number. \n");
	}
	
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		new StartUI(input).init();
	
	}
}