package ru.job4j.simplegenerator;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleGeneratorTest {
    SimpleGenerator sg;

    @Test
    public void whenTryToUseSimpleGeneratorThenSeeThatItWorksWell() {
        sg = new SimpleGenerator();
        sg.generate("Some text.");
        ArrayList<String> list = new ArrayList<>();
        list.add("name");
        list.add("Petr");
        sg.addMapValue(list);
        list = new ArrayList<>();
        list.add("subject");
        list.add("you");
        sg.addMapValue(list);
        list = new ArrayList<>();
        list.add("sos");
        list.add("Aaa");
        sg.addMapValue(list);
        assertThat(sg.generate("I am ${name}. Who is ${subject}?"), is("I am Petr. Who is you?"));
        assertThat(sg.generate("Help, ${sos}, ${sos}, ${sos}"), is("Help, Aaa, Aaa, Aaa"));
    }
}
