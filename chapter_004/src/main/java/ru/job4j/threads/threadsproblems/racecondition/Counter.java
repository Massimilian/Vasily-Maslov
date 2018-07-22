package ru.job4j.threads.threadsproblems.racecondition;

public class Counter {
    boolean hasInfo;
    boolean wasChanged = false;

    public void setInfo(boolean setInfo) {
        hasInfo = setInfo;
    }
}
