package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = getPersons("src\\com\\company\\tests\\persons.txt");
        GraphOfPersons g = new GraphOfPersons(persons);
        setRelations("src\\com\\company\\tests\\relations.txt", g);
        setHobby("src\\com\\company\\tests\\hobby.txt", g);

        for (Person p : Services.getPersons(g)) {
            System.out.print(p.getName() + ", " + (p.getGender() ? "male" : "female"));
            for (Hobby h : p.getHobby()) {
                System.out.print(", like " + h);
            }
            System.out.println();
            for (Relation r : p.getRelations()) {
                System.out.println("\t" + r.getType() + " with " + ((r.getP1().equals(p)) ? r.getP2().getName() : r.getP1().getName()));
            }
        }
    }

    public static List<Person> getPersons(String file) {
        List<Person> persons = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] array = line.split(", *");
                persons.add(new Person(array[0], array[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public static void setRelations(String file, GraphOfPersons g) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] array = line.split(", *");
                Type type;
                switch (array[2]) {
                    case "COLLEAGUES":
                        type = Type.COLLEAGUES;
                        break;
                    case "FRIENDSHIP":
                        type = Type.FRIENDSHIP;
                        break;
                    case "COUPLE":
                        type = Type.COUPLE;
                        break;
                    case "FAMILY":
                        type = Type.FAMILY;
                        break;
                    default:
                        type = null;
                }
                Services.addRelation(g, Integer.parseInt(array[0]), Integer.parseInt(array[1]), type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setHobby(String file, GraphOfPersons g) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] array = line.split(", *");
                Hobby hobby;
                switch (array[1]) {
                    case "FOOTBALL":
                        hobby = Hobby.FOOTBALL;
                        break;
                    case "BASKETBALL":
                        hobby = Hobby.BASKETBALL;
                        break;
                    case "CHESS":
                        hobby = Hobby.CHESS;
                        break;
                    case "SKI":
                        hobby = Hobby.SKI;
                        break;
                    case "BIKE":
                        hobby = Hobby.BIKE;
                        break;
                    default:
                        hobby = null;
                }
                Services.getPerson(g,Integer.parseInt(array[0])).addHobby(hobby);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
