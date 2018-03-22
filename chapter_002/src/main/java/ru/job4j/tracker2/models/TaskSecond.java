package ru.job4j.tracker2.models;

public class TaskSecond extends ItemSecond {
	public TaskSecond(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	
	public TaskSecond(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
}