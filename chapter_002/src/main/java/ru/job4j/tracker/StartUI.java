package ru.job4j.tracker;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 06/02/2018
 */
 
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    Tracker tracker = new Tracker();
	//Input input = new Input();
	//создаётся экземпляр интерфейса, соответственно - в класс StartUI может создаться не экземпляр класса, а экземпляр интерфейса. Как это вообще возможно?
	ConsoleInput input = new ConsoleInput();
	
    public StartUI(Tracker tracker, ConsoleInput input) {
        this.tracker = tracker;
		this.input = input;
    }

    private void showMenu() {
        System.out.printf("Введите команду:\n0.\tВнести новую заявку / Add new Item\n1.\tПоказать все заявки / Show all items\n2.\tРедактировать заявку / Edit item\n3.\tУдалить заявку / Delete item\n4.\tНайти заявку по персональному номеру / Find item by Id\n5.\tНайти заявку по имени / Find items by name\n6.\tВыйти из программы / Exit Program\n");
        System.out.println();
    }

    boolean doNotYouWantToContinue() {
        return input.ask("Хотите продолжать(1/0)?").equals("1") ? false : true;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = input.ask("Введите пункт меню");
            switch (answer) {
                case(ADD):
                    this.createItem();
                    exit = this.doNotYouWantToContinue();
                    break;
                case(SHOW):
                    this.showItems();
                    exit = this.doNotYouWantToContinue();
                    break;
                case(EDIT):
                    break;
                case(DELETE):
                    this.deleteItem();
                    exit = this.doNotYouWantToContinue();
                    break;
                case(FIND_BY_ID):
                    this.findById();
                    exit = this.doNotYouWantToContinue();
                    break;
                case(FIND_BY_NAME):
                    this.findByName();
                    exit = this.doNotYouWantToContinue();
                    break;
                case(EXIT):
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        Item item = new Item(input.ask("Введите имя заявки :"), input.ask("Введите описание заявки :"));
        this.tracker.add(item);
        System.out.println("------------ Новая заявка под номером : " + item.getId() + " добавлена. -----------");
        System.out.println();
    }

    private void showItems() {
        this.showMeChangedItems(this.tracker.findAll());
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        this.tracker.delete(input.ask("Укажите номер заявки, которую следует удалить"));
        System.out.println("Заявка успешно удалена");
    }

    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        this.showMeChangedItems(this.tracker.findByName(input.ask("Введите имя заявки :")));
    }

    private void findById() {
        System.out.println("------------ Поиск заявки по номеру --------------");
        Item item = this.tracker.findById(input.ask("Введите имя заявки :"));
        if (item == null) {
            System.out.println("Заявка не найдена. Уточните данные и попробуйте ещё раз.");
        } else {
            System.out.printf("Информация по заявке номер  '%s':\tИмя - '%s', описание - '%s'.\n", item.getId(), item.getName(), item.getDescription());
        }
    }

    private void showMeChangedItems(Item[] items) {
        int count = 1;
        System.out.println("------------ Начало документа --------------");
        for (Item item : items) {
            System.out.printf("Заявка №%d:\tИмя - '%s', описание - '%s', номер - '%s'.\n", count, item.getName(), item.getDescription(), item.getId());
            count++;
        }
        System.out.println("------------ Конец документа --------------");
    }

    public static void main(String[] args) {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }
}