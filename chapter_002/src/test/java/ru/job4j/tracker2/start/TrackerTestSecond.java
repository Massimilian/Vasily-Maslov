package ru.job4j.tracker2.start;

import org.junit.After;
import org.junit.Before;
import ru.job4j.tracker2.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerTestSecond {
	TrackerSecond tracker = new TrackerSecond();
	InputSecond input = new ConsoleInputSecond();
	
	@Before
    public void setStub() {
        System.out.println("StubInput has been set");
		input = new StubInputSecond(new String[]{"1", "Task", "Desc", "7"});
    }

    @After
    public void setIn() {
		input = new ConsoleInputSecond();
        System.out.println("Input has been returned");
	}
	
	@Test
	public void whenAddItemThenPutItIntoArray() {
		new StartUISecond(input, tracker).init();
		assertThat(tracker.getItem(0).getDescription(), is("Desc"));
	}
}