package ru.job4j.menu.showers;

import ru.job4j.menu.interfaces.IAction;

import javax.swing.*;

public class ThirdShower extends AShower {
    @Override
    public String menuName(String name) {
        return String.format("%s%s%s %s", this.correct, this.correct, this.correct, name);
    }
}
