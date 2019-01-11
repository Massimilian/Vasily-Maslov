package ru.job4j.menu.showers;

public class FirstShower extends AShower {
    @Override
    public String menuName(String name) {
        return String.format("%s %s", this.correct, name);
    }
}
