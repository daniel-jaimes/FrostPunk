package model;

import java.util.HashSet;
import java.util.Set;


public class Edifice {
    private String name;
    private int minHeat;
    private int currentHeat;
    private Set<Person> people;
    protected Edifice(String name, int currentHeat, int minHeat){
        this.name = name;
        this.currentHeat = currentHeat;
        this.minHeat = minHeat;
        people = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public int getMinHeat() {
        return minHeat;
    }

    public int getCurrentHeat() {
        return currentHeat;
    }

    public Set<Person> getPeople() {
        return people;
    }
}
