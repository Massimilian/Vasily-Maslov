package ru.job4j.tracker2.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class AnotherTrackerSecondTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private String ls = System.lineSeparator();

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
		System.out.println("The before method finished.");
    }

   @Test
   public void whenInvalidInput() {
       ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "7", "y"}));
       input.ask("Enter", new int[] {1});
       assertThat(this.mem.toString(), is(String.format("Please enter valid data again.%s", ls)));
   }
}