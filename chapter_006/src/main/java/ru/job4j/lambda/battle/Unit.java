package ru.job4j.lambda.battle;

public class Unit implements Cloneable {
    private String name;
    private String type;
    private double actionOne;
    private double actionTwo;
    private boolean blessed = false;
    private boolean cursed = false;
    private double health = 100;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    public void setBlessed(boolean blessed) {
        this.blessed = blessed;
    }

    public boolean isBlessed() {
        return blessed;
    }

    public double getActionOne() {
        return actionOne;
    }

    public double getActionTwo() {
        return actionTwo;
    }

    public Unit(String name, String type, double actionOne, double actionTwo) {
        this.name = name;
        this.type = type;
        this.actionOne = actionOne;
        this.actionTwo = actionTwo;
    }

    @Override
    public String toString() {
        return String.format("%s %s", type, name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
