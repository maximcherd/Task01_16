package com.company;

import java.util.ArrayList;
import java.util.List;

public class GraphOfPersons {
    private List<Person> persons = new ArrayList<>();

    public GraphOfPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(String name, String gender) {
        persons.add(new Person(name, gender.equals("male")));
    }

    public Person getPerson(int index) {
        if (index >= 0 && index < persons.size()) {
            return persons.get(index);
        }
        return null;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
