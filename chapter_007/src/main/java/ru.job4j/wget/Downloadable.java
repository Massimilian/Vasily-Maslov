package ru.job4j.wget;

public class Downloadable {
    private final String request;
    private final int speed;

    public Downloadable(String request, int speed) {
        this.request = request;
        this.speed = speed * 1024;
    }

    public String getRequest() {
        return request;
    }

    public int getSpeed() {
        return speed;
    }
}
