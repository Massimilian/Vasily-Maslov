package ru.job4j.archive.story;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Food ball = new Ball();
        LinkedList<Animal> animals = new LinkedList<>();
        animals.add(new Hare("Заяц"));
        animals.add(new Wolf("Волк"));
        animals.add(new Fox("Лиса"));
        animals.add(new Animal("Animal") {
            @Override
            public void eat(Food food) {
                super.eat(food);
            }
        });
        while (!ball.isEaten() || animals.isEmpty()) {
            System.out.printf("Катится, катится Колобок. А навстречу ему %s.%s", animals.peek().getName(), System.lineSeparator());
            animals.poll().eat(ball);
        }
    }
}
