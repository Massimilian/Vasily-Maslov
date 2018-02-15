package ru.job4j.profeccions;

public class Doctor extends Person {
	private int howManyJobs;
	private boolean newHospitalNeed;
	private long fat;
	
	public Doctor(String name, int howManyJobs, long fat) {
		super.name = name;
		this.howManyJobs = howManyJobs;
		this.fat = fat;
		this.newHospitalNeed = false;
	}
	
	public Teacher heal(Teacher teacher) {
		if (teacher.getHealth() < 0) {
			teacher.setHealth(0);
		}
		teacher.setHealth(teacher.getHealth() * 2 + 0.1);
		return teacher;
	}
	
	public void doYouNeedMore() {
		this.newHospitalNeed = howManyJobs < 5 ? true : false;
	}
	
	public int getHowManyJobs() {
		return this.howManyJobs;
	}
	
	public void setHowManyJobs(int howManyJobs) {
		this.howManyJobs = howManyJobs;
	}
	
	public boolean getNewHospitalNeed() {
		return this.newHospitalNeed;
	}
	
	// если развивать программу дальше, то параметр howManyJobs со временем должен падать. Для этого будет нужен отдельный метод, привязанный к отсчёту времени.
}