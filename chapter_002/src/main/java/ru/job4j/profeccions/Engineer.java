package ru.job4j.profeccions;

public class Engineer extends Person {
	public long knowledge;
	public boolean teachNeed;
	public short altitude;
	
	public Engineer(String name, long knowledge, short altitude) {
		super.name = name;
		this.knowledge = knowledge;
		this.altitude = altitude;
		this.teachNeed = false;
	}
	
	public Doctor setHospital(Doctor doctor) {
		if (doctor.newHospitalNeed) {
			doctor.howManyJobs++;
		}
		return doctor;
	}
	
	public void studying() {
		this.teachNeed = knowledge < 8 ? true : false;
	}
}