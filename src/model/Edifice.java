package model;

import java.util.HashSet;
import java.util.Set;


public class Edifice {
    private Buildings.name name;
    private int minHeat;
    private int currentHeat;
    private Set<Person> people;
    protected Edifice(Buildings.name name, int currentHeat, int minHeat){
        this.name = name;
        this.currentHeat = currentHeat;
        this.minHeat = minHeat;
        people = new HashSet<>();
    }

}
