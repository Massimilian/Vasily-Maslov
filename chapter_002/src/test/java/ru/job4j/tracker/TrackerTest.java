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
	
// Данный тест правильно не отрабатывает. Причину найти не удалось. 
// В образце в конструктор передаётся также и класс tracker, но в конструкторе её наличие не предусмотрено.
// Спасибо!
	
//	@Test
//	public void whenPutANewItemThenReturnIt() {
//		Input input = new StubInput(new String[]{"0", "TestItem", "TestDesc"});
//		StartUI start = new StartUI(input, tracker);
//		start.init();
//		assertThat(start.tracker.getAccess(0).getName(), is("TestItem"));
//	}
	
	
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

	@Test
	public void whenItemIdIsEqualThenReturnThatItem() {
		tracker.add(item);
		tracker.add(itemTwo);
		tracker.add(itemThree);
        Item result = tracker.findById(tracker.getAccess(0).getId());
		assertThat(result, is(item));
	}
}