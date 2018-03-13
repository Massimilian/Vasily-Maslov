package ru.job4j.tracker1.start;

import ru.job4j.tracker1.models.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerTest {
	Tracker tracker = new Tracker();
	Item item = new Item("Name", "Desc");
	Item anotherItem = new Item("AnotherName", "AnotherDesc");
	
	@Test
	public void whenAddNewItemThenPutItInArray() {
		tracker.add(item);
		assertThat(tracker.getItem(0), is(item));
	}
	
	@Test
	public void whenReplaceAnItemThenPutANewItem() {
		tracker.add(item);
		tracker.replace(item.getId(), anotherItem);
		assertThat(tracker.getItem(0).getName(), is(anotherItem.getName()));
	}
	
	@Test
	public void whenDeleteAnItemThenReturnNull() {
		tracker.add(item);
		tracker.delete(item.getId());
		assertThat(tracker.getPosition(), is(0));
	}
	
	@Test
	public void whenAskItemsByNameThenReturnAll() {
		tracker.add(item);
		tracker.add(anotherItem);
		tracker.add(item);
		assertThat(tracker.getItem(2).getName(), is(tracker.findByName(item.getName())[1].getName()));
	}
	
	@Test
	public void whenAskTrackerByIdThenReturnIt() {
		tracker.add(item);
		assertThat(tracker.getItem(0), is(tracker.findById(tracker.getItem(0).getId())));
	}
	
	// Суть работы StubInput понял после "глобальной перезагрузки".
	// Но теперь мне неясно - как заставить Stubinput "узнавать" формируемый по ходу дела id-номер конкретной заявки?
	// Без id не получится сделать полностью автоматизированный тест.
	// И - если мы проверяем метод, выводящий информацию на консоль - как можно считать с консоли выведенную информацию?

	@Test
	public void whenAddNewItemThenPutItInArrayAutoTesting() {
		Input input = new StubInput(new String[]{"1", "Task", "Desc", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getItem(0).getName(), is("Task"));
	}
}