package ru.job4j.tracker2.start;

import ru.job4j.tracker2.models.*;
import java.util.*;

public class TrackerSecond {
	private ItemSecond[] items = new ItemSecond[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	public ItemSecond getItem(int position) {
		ItemSecond item = new ItemSecond();
		if (position <= this.position && position >= 0) {
			item = items[position];
		}
		return item;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public ItemSecond add(ItemSecond item) {
		item.setId(this.generateId());
		this.items[this.position++] = item;
		return item;
	}

	public void update(ItemSecond fresh) {
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null && this.items[i].getId().equals(fresh.getId())) {
				items[i] = fresh;
				break;
			}
		}
	}
	
	public void replace(String id, ItemSecond item) { // поменять заполнение заявки (старый вариант)
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
	
	public ItemSecond[] findAll() { // в ТЗ указано создать метод, который фактически уже создан в лекции; делаю просто ссылку на него. Необходимсти делать на него тест не вижу - тест будет проверять сам себя.
		return this.getAll();
	}
	
	public ItemSecond[] findByName(String key) {
		ItemSecond[] result = new ItemSecond[this.position];
		int length = 0;
		for (ItemSecond item : items) {
			if (item != null && item.getName().equals(key)) {
				result[length] = item;
				length++;
			}
		}
		ItemSecond[] finalResult = new ItemSecond[length];
		for (int i = 0; i < length; i++) {
			finalResult[i] = result[i];
		}
		return finalResult;
	}
	
	protected ItemSecond findById(String id) {
		ItemSecond result = null;
		for (ItemSecond item : items) {
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
	
	public ItemSecond[] getAll() {
		ItemSecond[] result = new ItemSecond[this.position];
		for (int i = 0; i != this.position; i++) {
			result[i] = this.items[i];
		}
		return result;
	}
	
	public ItemSecond createNewItem(String name, String desc) {
		return new ItemSecond(name, desc);
	}
	
	private ItemSecond[] editItems(ItemSecond[] item, int length) {
	ItemSecond[] tempItem = new ItemSecond[length];
	for (int i = 0; i < tempItem.length; i++) {
		tempItem[i] = item[i];	
		}
	return tempItem;
	}	
}