package ru.job4j.tracker2.start.interfaces;

import ru.job4j.tracker2.start.interfaces.ITrackerSQL;
import ru.job4j.tracker2.start.interfaces.ITrackerStandart;
import ru.job4j.tracker2.start.interfaces.Input;

public interface UserAction {
    int key();

    void execute(Input input, ITrackerSQL tracker);

    void execute(Input input, ITrackerStandart tracker);

    String info();
}