package ru.job4j.archive.cats;

public class Cat {
    private String name;
    private String food;

    public void show() {
        System.out.printf("Cat %s eats %s.%s", this.name, this.food, System.lineSeparator());
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

}
