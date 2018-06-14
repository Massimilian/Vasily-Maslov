package ru.job4j.phonebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {
    PhoneDictionary pd = new PhoneDictionary();
    Person person = new Person("Name", "Surname", "PhoneNumber", "Address");
    Person person1 = new Person("Vasily", "Maslov", "Anknown", "Anknown");
    Person person2 = new Person("Somebody", "Anybody", "Something", "Anywhere");
    List<Person> result = new ArrayList<>();


    @Test
    public void whenTryToPutThePersonIntothePhoneDictionaryThenDoIt() {
        pd.addPerson(person);
        assertThat(pd.showAll().get(0), is(person));
    }

    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryBySurnameThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person1);
        assertThat(pd.find("Maslov"), is(result));
    }


    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryByNumberThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person2);
        assertThat(pd.find("Something"), is(result));
    }

    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryBySurnameMoreEasyWayThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person1);
        assertThat(pd.findMoreEasyWay("Mas"), is(result));
    }


    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryByNumberMoreEasyWayThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person2);
        assertThat(pd.findMoreEasyWay("hing"), is(result));
    }


    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryBySurnameAnotherWayThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person1);
        assertThat(pd.findAnotherWay("Mas"), is(result));
    }


    @Test
    public void whenTryToFindThePersonFromThePhoneDictionaryByNumberAnotherWayThenReturnIt() {
        pd.addPerson(person);
        pd.addPerson(person1);
        pd.addPerson(person2);
        result.add(person2);
        assertThat(pd.findAnotherWay("hing"), is(result));
    }
}
