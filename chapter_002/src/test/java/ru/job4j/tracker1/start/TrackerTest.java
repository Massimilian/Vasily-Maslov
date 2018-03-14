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
	
	@Test
	public void whenAddNewItemThenPutItInArrayAutoTesting() {
		Input input = new StubInput(new String[]{"1", "Task", "Desc", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getItem(0).getName(), is("Task"));
	}
		
	@Test
	public void whenReplaceAnItemThenPutANewItemAutoTesting() {
		tracker.add(item);
		tracker.getItem(0).setId("0000");
		Input input = new StubInput(new String[]{"2", "0000", "NewTask", "NewDesc", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getItem(0).getDescription(), is("NewDesc"));
	}
	
	@Test
	public void whenDeleteAnItemThenReturnNullAutoTesting() {
		tracker.add(item);
		tracker.getItem(0).setId("0000");
		Input input = new StubInput(new String[]{"3", "0000", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getPosition(), is(0));
	}
	
	@Test
	public void whenAskItemsByNameThenReturnAllAutoTesting() {
		Input input = new StubInput(new String[]{"1", "Name0", "Desc0", "y", "1", "Name1", "Desc1", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getItem(1).getName(), is("Name1"));
	}
	
	@Test
	public void whenAskTrackerByIdThenReturnItAutoTesting() {
		tracker.add(item);
		tracker.getItem(0).setId("0000");
		Input input = new StubInput(new String[]{"6", "0000", "n"});
		new StartUI(input, tracker).init();
		assertThat(tracker.getItem(0).getId(), is("0000"));		
	}
}