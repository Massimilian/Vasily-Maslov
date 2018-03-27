package ru.job4j.tracker2.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class AnotherTrackerTestSecond {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
		System.out.println("The before method started.");
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
		System.out.println("The before method finished.");
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInputSecond(new String[] {"invalid", "7", "y"}));
        input.ask("Enter", new int[] {1});
        assertThat(this.mem.toString(), is(String.format("Please enter valid data again.")));
    }
}