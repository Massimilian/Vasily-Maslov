package ru.job4j.tracker1.start;

import ru.job4j.tracker1.models.*;
import java.util.*;

public class Tracker {
	private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	public Item getItem(int position) {
		Item item = new Item();
		if (position <= this.position && position >= 0) {
			item = items[position];
		}
		return item;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}

	public void replace(String id, Item item) { // поменять заполнение заявки
		for (int i = 0; i < this.position; i++) {
			if (this.items[i] != null && items[i].getId().equals(id)) {
				items[i] = item;
				break;
			}
		}
	}
	
	public void delete(String id) {
	for (int i = 0; i < this.position; i++) {
		if (items[i].getId().equals(id)) {
			items[i] = null;
			if (this.position > 1) {
			items[i] = items[position - 1];
			}
		break;
		}
	}
	this.editItems(this.items, this.position--);
	}
	
	public Item[] findAll() { // в ТЗ указано создать метод, который фактически уже создан в лекции; делаю просто ссылку на него. Необходимсти делать на него тест не вижу - тест будет проверять сам себя.
		return this.getAll();
	}
	
	public Item[] findByName(String key) {
		Item[] result = new Item[this.position];
		int length = 0;
		for (Item item : items) {
			if (item != null && item.getName().equals(key)) {
				result[length] = item;
				length++;
			}
		}
		Item[] finalResult = new Item[length];
		for (int i = 0; i < length; i++) {
			finalResult[i] = result[i];
		}
		return finalResult;
	}
	
	protected Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
	
	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int i = 0; i != this.position; i++) {
			result[i] = this.items[i];
		}
		return result;
		// а почему бы просто не так?
		// return this.items;
	}
	
	public Item createNewItem(String name, String desc) {
		return new Item(name, desc);
	}
	
	private Item[] editItems(Item[] item, int length) {
	Item[] tempItem = new Item[length];
	for (int i = 0; i < tempItem.length; i++) {
		tempItem[i] = item[i];	
		}
	return tempItem;
	}
	
	
}