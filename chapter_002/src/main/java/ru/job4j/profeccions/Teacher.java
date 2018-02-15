package ru.job4j.profeccions;

public class Teacher extends Person {
	private double health;
	private boolean healNeed;
	private int age;
	
	public Teacher(String name, double health, int age) {
		super.name = name;
		this.health = health;
		this.age = age;
		this.healNeed = false;
	}
	
	public Engineer teach(Engineer engineer) {
		engineer.setKnowledge(engineer.getKnowledge() + 8);
		this.health = this.health - 1.6;
		return engineer;
	}
	
	public void lookHealth() {
		this.healNeed = this.health < 1 ? true : false;
	}
	
	public double getHealth() {
		return this.health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
}