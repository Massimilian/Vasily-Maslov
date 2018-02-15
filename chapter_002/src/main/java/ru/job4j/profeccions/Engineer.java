package ru.job4j.profeccions;

public class Engineer extends Person {
	private long knowledge;
	private boolean teachNeed;
	private short altitude;
	
	public Engineer(String name, long knowledge, short altitude) {
		super.name = name;
		this.knowledge = knowledge;
		this.altitude = altitude;
		this.teachNeed = false;
	}
	
	public Doctor setHospital(Doctor doctor) {
		if (doctor.getNewHospitalNeed()) {
			doctor.setHowManyJobs(doctor.getHowManyJobs() + 1);
		}
		return doctor;
	}
	
	public void studying() {
		this.teachNeed = knowledge < 8 ? true : false;
	}
	
	public long getKnowledge() {
		return this.knowledge;
	}
	
	public void setKnowledge(long knowledge) {
		this.knowledge = knowledge;
	}
}