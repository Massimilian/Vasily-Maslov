package ru.job4j.tracker;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 02/02/2018
 */
 
 public class Item {
	private String name;
	private String id;
	private String description;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Item(String name, String description, String id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
}
 