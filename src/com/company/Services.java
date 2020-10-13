package com.company;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public static List<Person> getPersons(GraphOfPersons graphOfPersons) {
        return graphOfPersons.getPersons();
    }

    public static void addPerson(GraphOfPersons graphOfPersons, String name, String gender) {
        graphOfPersons.addPerson(name, gender);
    }

    public static Person getPerson(GraphOfPersons graphOfPersons, int index) {
        return graphOfPersons.getPerson(index);
    }

    public static void addRelation(GraphOfPersons graphOfPersons, int index1, int index2, Type type) {
        addRelation(graphOfPersons.getPerson(index1), graphOfPersons.getPerson(index2), type);
    }

    public static void addRelation(Person p1, Person p2, Type type) {
        if (p1 != null && p2 != null) {
            Relation r = new Relation(p1, p2, type);
            p1.addRelation(r);
            p2.addRelation(r);
        }
    }

    public static List<Relation> getRelations(Person p1, Person p2) {
        List<Relation> list = new ArrayList<>();
        for (Relation r : p1.getRelations()) {
            if (r.getP2().equals(p2)) {
                list.add(r);
            }
        }
        return list;
    }
}
