package ru.job4j.tracker;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 02/02/2018
 */
 
 public class Item {
	public String name;
	public String id;
	public String description;

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
}
 