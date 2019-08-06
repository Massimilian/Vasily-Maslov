package ru.job4j.archive.story;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void eat(Food food) {
        if (food instanceof Ball) {
            tryEat(food);
        }
    }

    private void tryEat(Food food) {
        if (this instanceof Fox) {
            System.out.println("\"Прыгни мне на носок, спой ещё разок.\"");
            food.sing();
            System.out.println("А Лиса его - ам! - и съела.");
            food.setEaten(true);
        } else {
            System.out.println("\"Колобок, Колобок, я тебя съем!\"");
            food.sing();
            food.goAway();
        }
    }
}
