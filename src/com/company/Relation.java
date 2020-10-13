package com.company;

public class Relation {
    private Person p1, p2;
    private Type type;

    public Relation(Person p1, Person p2, Type type) {
        this.p1 = p1;
        this.p2 = p2;
        this.type = type;
    }

    public Person getP1() {
        return p1;
    }

    public Person getP2() {
        return p2;
    }

    public Type getType() {
        return type;
    }
}
