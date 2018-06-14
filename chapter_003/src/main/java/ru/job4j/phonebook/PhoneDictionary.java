package ru.job4j.phonebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public List<Person> showAll() {
        return this.persons;
    }

    public List<Person> findMoreEasyWay(String key) {
        List<Person> result = new ArrayList<>();
        char[] chkey = key.toCharArray();
        boolean needToPut;
        for (Person person : persons) {
            char[] chperson = person.toString().toCharArray();
            if (chperson.length >= chkey.length) {
                for (int j = 0; j < chperson.length - chkey.length + 1; j++) {
                    needToPut = true;
                    for (int k = 0; k < chkey.length; k++) {
                        if (chperson[j + k] != chkey[k]) {
                            needToPut = false;
                            break;
                        }
                    }
                    if (needToPut) {
                        result.add(person);
                    }
                }
            }
        }
        return result;
    }


    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        char[] keyToArray = key.toCharArray();
        boolean needToPut;
        for (Person person : persons) {
            char[][] counts = {person.getName().toCharArray(),
                    person.getSurname().toCharArray(),
                    person.getAddress().toCharArray(),
                    person.getPhoneNumber().toCharArray()};
            for (char[] count : counts) {
                if (count.length >= keyToArray.length) {
                    for (int j = 0; j < count.length - keyToArray.length + 1; j++) {
                        needToPut = true;
                        for (int k = 0; k < keyToArray.length; k++) {
                            if (count[j + k] != keyToArray[k]) {
                                needToPut = false;
                                break;
                            }
                        }
                        if (needToPut) {
                            result.add(person);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<Person> findAnotherWay(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.equals(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
