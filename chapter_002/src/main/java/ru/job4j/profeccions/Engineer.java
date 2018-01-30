package ru.job4j.profeccions;

public class Engineer extends Person {
	public long knowledge;
	public boolean teachNeed;
	public short altitude;
	
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