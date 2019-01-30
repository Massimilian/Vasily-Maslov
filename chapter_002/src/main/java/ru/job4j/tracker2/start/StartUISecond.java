package ru.job4j.tracker2.start;

import ru.job4j.tracker2.start.interfaces.*;

public class StartUISecond {
    private int[] ranges = {1, 2, 3, 4, 5, 6, 7, 0};
    private Input input;
    private ITracker tracker;
    private TrackerSQL trackersql = new TrackerSQL();
    boolean cont = true;

    public StartUISecond(Input input) {
        this.input = input;
        this.tracker = new Tracker();
        trackersql.activate();
    }

    public StartUISecond(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init(MenuTracker menu) {
        menu.fillActions();
        UserAction exit = new UserAction() { // анонимный класс
            public int key() {
                return 7;
            }

            public void execute(Input input, ITrackerStandart tracker) {
                if ("y".equals(input.ask("Do you want to exit?"))) {
                    System.exit(0);
                }
            }

            public void execute(Input input, ITrackerSQL tracker) {
                if ("y".equals(input.ask("Do you want to exit?"))) {
                    System.exit(0);
                }
            }

            public String info() {
                return String.format("%s . %s", this.key(), "Exit Program.");
            }
        };
        menu.addAction(exit);

        UserAction anotherExit = new UserAction() { // Вспомогательный анонимный класс
            public int key() {
                return 0;
            }

            public void execute(Input input, ITrackerStandart tracker) {
                System.out.println("Special exit worked.");
            }

            public void execute(Input input, ITrackerSQL tracker) {
                System.out.println("Special exit worked.");
            }

            public String info() {
                return String.format("%s . %s", this.key(), "Special exit from Program.");
            }
        };
        menu.addAction(anotherExit);
    }

    public void go(MenuTracker menu, boolean isSQL) {
        do {
            menu.show();
            System.out.println("");
            int result = input.ask("Select:", ranges);
            menu.select(result, isSQL);
            System.out.println("");
            cont = result == 0 ? false : true;
        } while (cont);
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        StartUISecond suis = new StartUISecond(input);
//      For SQL-tracker
//      MenuTracker menu = new MenuTracker(suis.input, suis.trackersql);
//      For standart tracker
        MenuTracker menu = new MenuTracker(suis.input, suis.tracker);
        boolean isSQL = menu.setIsSQL();
        suis.init(menu);
        suis.go(menu, isSQL);
    }
}