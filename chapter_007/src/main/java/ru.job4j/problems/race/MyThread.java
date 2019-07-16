package ru.job4j.problems.race;

public class MyThread extends Thread {
    private Resourse resourse;

    public void setResourseAndName(Resourse resourse) {
        this.resourse = resourse;
    }

    @Override
    public void run() {
        if (resourse.getI() != 0) {
            resourse.setI(0);
            System.out.printf("%s was the first!%s", Thread.currentThread().getName(), System.lineSeparator());
        } else {
            System.out.printf("%s was the second!%s", Thread.currentThread().getName(), System.lineSeparator());
        }
    }
}
