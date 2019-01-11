package ru.job4j.menu.showers;

/**
 * Special class for correctiong the menu's name show. Has different realizations.
 */
public abstract class AShower {
    protected String correct = "----";

    public String menuName(String name) {
        return name;
    }
}
