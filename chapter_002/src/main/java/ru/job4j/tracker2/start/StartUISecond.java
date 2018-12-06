package ru.job4j.tracker2.start;

public class StartUISecond {
    private int[] ranges = {1, 2, 3, 4, 5, 6, 7, 0};
    private InputSecond input;
    private ITracker tracker = new Tracker();
    boolean cont = true;

    public StartUISecond(InputSecond input) {
        this.input = input;
    }

    public StartUISecond(InputSecond input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, (Tracker) this.tracker);
        menu.fillActions();

        UserAction exit = new UserAction() { // анонимный класс
            public int key() {
                return 7;
            }

            public void execute(InputSecond input, Tracker tracker) {
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

            public void execute(InputSecond input, Tracker tracker) {
                System.out.println("Special exit worked.");
            }

            public String info() {
                return String.format("%s . %s", this.key(), "Special exit from Program.");
            }
        };
        menu.addAction(anotherExit);

        do {
            menu.show();
            System.out.println("");
            int result = input.ask("Select:", ranges);
            menu.select(result);
            System.out.println("");
            cont = result == 0 ? false : true;
        } while (cont);
    }

    public static void main(String[] args) {
        InputSecond input = new ValidateInput(new ConsoleInputSecond());
        new StartUISecond(input).init();
    }
}