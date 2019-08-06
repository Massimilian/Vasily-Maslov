package ru.job4j.archive.story;

public abstract class Food {
    private boolean isEaten = false;

    public abstract void sing();

    public abstract void goAway();

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }
}
