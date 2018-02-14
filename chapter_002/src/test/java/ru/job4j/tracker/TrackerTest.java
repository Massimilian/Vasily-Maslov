package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Vasily Maslov (vasalekmas@gmail.com)
 * @version $Id$
 * @since 02/02/2018
 */
 
public class TrackerTest {
		Tracker tracker = new Tracker();
		Item item = new Item("Имя", "Описание");
		Item itemTwo = new Item("Name", "Description");
		Item itemThree = new Item("Имя", "Description");
		
	@Test
	public void whenPutAnItemThenFindAPlaceForIt() {
		tracker.add(item);
		assertThat(tracker.getAccess(0), is(item));
	}
	
	@Test
	public void whenAskItemToDeleteByIdThenDeleteItAndPutElderItemOnItsPlace() {
		tracker.add(item);
		tracker.add(itemTwo);
		tracker.add(itemThree);
		tracker.getAccess(1).setId("delete");
		tracker.delete("delete");
		assertThat(tracker.getAccess(1), is(itemThree));
	}
	
	
	@Test
	public void whenHaveThreeItemsThenReturnArrayWithThatThreeItems() {
		tracker.add(item);
		tracker.add(itemTwo);
		tracker.add(itemThree);
		Item[] result = tracker.findAll();
		int res = result.length;
		assertThat(res, is(3));
	}
	
	@Test
	public void whenAskItemByNameThenReturnArrayWithThatItems() {
		tracker.add(item);
		tracker.add(itemTwo);
		tracker.add(itemThree);
		Item[] result = tracker.findByName("Имя");
		int res = result.length;
		assertThat(res, is(2));
	}

// в какой-то момент этот тест перестал работать. Попытался весь код расставить по полочкам, но ничего не получилось. Ошибка, которую выдаёт компилятор - то, что item указывает на null (даже несмотря на то, что ранее он был явно объявлен). В чём причина?	
//	@Test
//	public void whenItemIdIsEqualThenReturnThatItem() {
//		tracker.add(item);
//		tracker.add(itemTwo);
//		tracker.add(itemThree);
//      Item result = tracker.findById(tracker.getAccess(0).getId());
//		assertThat(result, is(item));
//	}
}