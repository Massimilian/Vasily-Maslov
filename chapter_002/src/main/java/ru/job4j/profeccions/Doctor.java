package ru.job4j.profeccions;

public class Doctor extends Person {
	public int howManyJobs;
	public boolean newHospitalNeed;
	public long fat;
	
	public Doctor(String name, int howManyJobs, long fat) {
		super.name = name;
		this.howManyJobs = howManyJobs;
		this.fat = fat;
		this.newHospitalNeed = false;
	}
	
	public Teacher heal(Teacher teacher) {
		if (teacher.health < 0) {
			teacher.health = 0;
		}
		teacher.health = teacher.health * 2 + 0.1;
		return teacher;
	}
	
	public void doYouNeedMore() {
		this.newHospitalNeed = howManyJobs < 5 ? true : false;
	}
	// если развивать программу дальше, то параметр howManyJobs со временем должен падать. Для этого будет нужен отдельный метод, привязанный к отсчёту времени.
}