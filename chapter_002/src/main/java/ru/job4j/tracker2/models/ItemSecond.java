package ru.job4j.tracker2.models;

public class ItemSecond {
	protected String id;
	public String name;
	public String description;
	public long create;
	
	public ItemSecond(String name, String description, long create) {
		this.name = name;
		this.description = description;
		this.create = create;
	}
	
	public ItemSecond(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public ItemSecond() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public long getCreate() {
		return this.create;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}