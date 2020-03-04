package ru.job4j.journal;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JournalTest {
    @Test
    public void WhenTryToPutNewPupilTheDoIt() {
        Journal.getInstance().addNewPupil("Vasia");
        assertThat(Journal.getInstance().prepareTable().length, is(1));
        Journal.getInstance().addNewPupil("Olga");
        Journal.getInstance().addNewDiscipline("Mathematic");
        Journal.getInstance().addNewDiscipline("Music");
        assertThat(Journal.getInstance().prepareTable()[1].length, is(4));
        HashMap<String, String> mapVasia = new HashMap<>();
        mapVasia.put("Mathematic", "5");
        mapVasia.put("Music", "4");
        Journal.getInstance().addMarks("Vasia", mapVasia);
        HashMap<String, String> mapOlga = new HashMap<>();
        mapOlga.put("Mathematic", "5");
        mapOlga.put("Music", "5");
        Journal.getInstance().addMarks("Olga", mapOlga);
        String[][] test = Journal.getInstance().prepareTable();
        assertThat(test[0][1].equals("5") == test[1][1].equals("5"), is(true));
        Journal.getInstance().deletePupil("Vasia");
        test = Journal.getInstance().prepareTable();
        assertThat(Journal.getInstance().prepareTable().length, is(1));
        Journal.getInstance().deleteDiscipline("Mathematic");
        assertThat(Journal.getInstance().prepareTable()[0].length, is(3));
        Journal.getInstance().deleteAll();
    }
}
