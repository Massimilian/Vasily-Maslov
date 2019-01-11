package ru.job4j.menu;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import ru.job4j.menu.interfaces.IMenu;
import ru.job4j.menu.showers.FirstShower;
import ru.job4j.menu.showers.SecondShower;
import ru.job4j.menu.showers.ZeroShower;

public class MenuTest {
    IMenu menuMenuMenu = new Menu("Tarea 1.1.1", new SecondShower());
    IMenu menuMenuMenuTwo = new Menu("Tarea 1.1.2", new SecondShower());
    IMenu menuMenuMenuThree = new Menu("Tarea 1.1.3", new SecondShower());
    IMenu menuMenu = new Menu("Tarea 1.1", new FirstShower(), new IMenu[]{menuMenuMenu, menuMenuMenuTwo, menuMenuMenuThree});
    IMenu menuMenuTwo = new Menu("Tarea 1.2", new FirstShower());
    IMenu menu = new Menu("Tarea 1", new ZeroShower(), new IMenu[]{menuMenu, menuMenuTwo});
    IMenu menuTwo = new Menu("Tarea 2", new ZeroShower());
    IMenu menuThree = new Menu("Tarea 3", new ZeroShower());
    IMenu[] main = {menu, menuTwo, menuThree};
    String result = "";
    String answer = String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", System.lineSeparator(), "Tarea 1", System.lineSeparator(), "---- Tarea 1.1", System.lineSeparator(),
            "-------- Tarea 1.1.1", System.lineSeparator(), "-------- Tarea 1.1.2", System.lineSeparator(),
            "-------- Tarea 1.1.3", System.lineSeparator(), "---- Tarea 1.2", System.lineSeparator(),
            "Tarea 2", System.lineSeparator(), "Tarea 3");

    @Test
    public void WhenAskAllTareasThenReturnThem() {
        for (int i = 0; i < main.length; i++) {
            result = String.format("%s%s%s", result, System.lineSeparator(), main[i].getMenuName());
        }
        assertThat(result, is(answer));
    }
}
