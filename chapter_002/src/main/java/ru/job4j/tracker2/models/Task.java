package ru.job4j.tracker2.models;

public class Task extends Item {
	public Task(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	
	public Task(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
}