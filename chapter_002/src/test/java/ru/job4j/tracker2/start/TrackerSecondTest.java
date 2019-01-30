package ru.job4j.tracker2.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker2.start.interfaces.Input;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSecondTest {
	private Tracker tracker = new Tracker();
	private Input input = new ConsoleInput();
	
	@Before
    public void setStub() {
        System.out.println("StubInput has been set");
		input = new StubInput(new String[]{"1", "Task", "Desc", "1", "Task", "Desc", "0"});
	}

    @After
    public void setIn() {
		input = new ConsoleInput();
        System.out.println("Input has been returned");
	}
	
	@Test
	public void whenAddItemThenPutItIntoArray() {
		StartUISecond suis = new StartUISecond(input, tracker);
		MenuTracker menu = new MenuTracker(input, tracker);
		suis.init(menu);
		suis.go(menu, false);
		assertThat(tracker.getItem(1).getDescription(), is("Desc"));
	}
}