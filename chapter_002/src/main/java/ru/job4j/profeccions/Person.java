package ru.job4j.profeccions;

public class Person {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
	// конструктор сделан для возможного будущего создания персоналий с именами. Пока прописан конструктор default для удобства. 
	
	public Person() {
	}
	
	public String getName() {
	return this.name;
	}
	
	public void work() {
	}
	
}