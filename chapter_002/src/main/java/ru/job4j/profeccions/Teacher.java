package ru.job4j.profeccions;

public class Teacher extends Person {
	public double health;
	public boolean healNeed;
	public int age;
	
	public Engineer teach(Engineer engineer) {
		engineer.knowledge = engineer.knowledge + 8;
		this.health = this.health - 1.6;
		return engineer;
	}
	
	public void lookHealth() {
		this.healNeed = this.health < 1 ? true : false;
	}
}