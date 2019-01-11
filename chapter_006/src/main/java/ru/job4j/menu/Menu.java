package ru.job4j.menu;

import ru.job4j.menu.interfaces.IAction;
import ru.job4j.menu.interfaces.IMenu;
import ru.job4j.menu.showers.AShower;

public class Menu implements IMenu {
    String name;
    AShower shower;
    IMenu[] menus;

    public Menu(String name, AShower shower, IMenu[] menus) {
        this.name = name;
        this.shower = shower;
        this.menus = menus;
    }

    public Menu(String name, AShower shower) {
        this.name = name;
        this.shower = shower;
    }

    @Override
    public String getMenuName() {
        String result = this.shower.menuName(this.name);
        if (menus != null) {
            for (int i = 0; i < menus.length; i++) {
                result = String.format("%s%s%s", result, System.lineSeparator(), menus[i].getMenuName());
            }
        }
        return result;
    }
}
