package ru.job4j.tracker;

import java.util.Random;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 02/02/2018
 */
public class Tracker {
    public final Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

	
    public Item add(Item item) {
//      item.setId(this.generateId());
        item.setId(this.generateIdAnotherMethod());
//		item.setId(this.generateIdMostBigMethod());
		this.items[this.position++] = item;
        return item;
    }

    public Item getAccess(int arrayNumber) {
        return this.items[arrayNumber];
    }

    public void replace(String id, Item item) {
        int numberOfArray;
        for (int i = 0; i < this.items.length; i++) {
            if (item.getId().equals(id)) {
                numberOfArray = i;
            }
        }
    }
	    // номер ячейки выяснили, присвоили в numberOfArray. А куда его теперь переносить (извините, не совсем понял задание)?

    public void delete(String str) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(str)) {
                this.items[count] = null;
            }
            count++;
        }
        exceptNulls(this.items);
		this.position--;
	// позицию добавления заявки в массив также необходимо уменьшить на один, согласно уменьшенному количеству ячеек.
    }

    public Item[] findAll() {
        int notNull = 0;
        for (Item it : this.items) {
            if (it != null) {
            notNull++;
            }
        }
        Item[] result = new Item[notNull];
        System.arraycopy(this.items, 0, result, 0, notNull);
        return result;
    }


    public Item[] findByName(String key) {
        int count = 0;
        for (Item it : this.items) {
            if (it != null && it.getName().equals(key)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < this.items.length; j++) {
                if (this.items[j] != null && this.items[j].getName().equals(key)) {
                    result[i] = this.items[j];
                }
            }
        }
        return result;
    }


    public Item findById(String id) {
        Item item = null;
        for (Item it : this.items) {
            if (it.getId().equals(id)) {
                item = it;
                break;
            }
        }
        return item;
    }


    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
// почему бы не воспользоваться упрощённым вариантом кода, без привязки ко времени, предложенным ниже?
	private String generateIdAnotherMethod() {
		return String.valueOf(RN.nextInt(Integer.MAX_VALUE));
	}
// кроме того, можно наверняка избежать совпадений следующим образом
	private String generateIdMostBigMethod() {
		int number;
		boolean isDuplicate = false;
		do {
			number = RN.nextInt(Integer.MAX_VALUE);
			for (Item item : this.items) {
			if (item != null && item.getId().equals(String.valueOf(number))) {
					isDuplicate = true;
				}
			}
		} while (isDuplicate);
		return String.valueOf(number);
    }

    private void exceptNulls(Item[] items) {
        int count = 0;
        Item[] tempItem = new Item[items.length];
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
			tempItem[count] = this.items[i];
            count++;
			}
        }
        count = 0;
        for (int i = 0; i < tempItem.length; i++) {
            this.items[i] = tempItem[i];
        }
	}
    // если бы массив items не был бы финальным, это упростило бы жизнь - можно было бы просто приравнять массив
}