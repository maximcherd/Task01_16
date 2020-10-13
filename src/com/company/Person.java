package com.company;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private boolean gender;
    private List<Relation> relations = new ArrayList<>();
    private List<Hobby> hobby = new ArrayList<>();

    public Person(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender.equals("male");
    }

    public void addRelation(Person person, Type type) {
        relations.add(new Relation(this, person, type));
    }

    public void addRelation(Relation r) {
        relations.add(r);
    }

    public void addHobby(Hobby h) {
        hobby.add(h);
    }

    public String getName() {
        return name;
    }

    public boolean getGender() {
        return gender;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }
}
