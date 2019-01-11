package ru.job4j.menu.showers;

public class SecondShower extends AShower {
    @Override
    public String menuName(String name) {
        return String.format("%s%s %s", this.correct, this.correct, name);
    }
}
