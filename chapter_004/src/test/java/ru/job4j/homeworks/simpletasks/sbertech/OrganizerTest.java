package ru.job4j.homeworks.simpletasks.sbertech;

import org.junit.Test;
import ru.job4j.homeworks.sbertech.Organizer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OrganizerTest {
    String[] firstInfo = {"Vasily", "Student", "job4j", "vasalekmas@gmail.com", "+79629762999"};
    String[] secondInfo =  {"Olga", "Teacher", "DSHI", "raushen@mail.ru", "+79031172293"};

    @Test
    public void tryToMakeOrganizer() {
        Organizer organizer = new Organizer();
    }

    @Test
    public void showWhatDoYouCan() {
        Organizer organizer = new Organizer();
        organizer.help();
    }

    @Test
    public void tryToInsertValue() {
        Organizer organizer = new Organizer();
        organizer.insert(firstInfo);
    }

    @Test
    public void tryToChangeValue() {
        Organizer organizer = new Organizer();
        organizer.insert(firstInfo);
        organizer.update("Vasily", secondInfo);
    }

    @Test
    public void tryToDeleteValue() {
        Organizer organizer = new Organizer();
        organizer.insert(firstInfo);
        organizer.insert(secondInfo);
        organizer.delete("Vasily");
    }

    @Test
    public void tryToPrintInfo() {
        Organizer organizer = new Organizer();
        organizer.insert(firstInfo);
        organizer.insert(secondInfo);
        organizer.findByTel("+79031172293");
    }

    @Test
    public void tryToShowThemAll() {
        Organizer organizer = new Organizer();
        organizer.insert(secondInfo);
        organizer.insert(firstInfo);
        organizer.list();
    }
}
