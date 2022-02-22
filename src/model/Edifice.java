package model;

import java.util.*;


public class Edifice {
    private Buildings name;
    private int minHeat;
    private int currentHeat;
    private Set<Person> people;
    protected Edifice(Buildings name, int currentHeat, int minHeat){
        this.name = name;
        this.currentHeat = currentHeat;
        this.minHeat = minHeat;
        people = new TreeSet<>();
    }

    public Buildings getName() {
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

    public boolean addPerson(Person person) {
        return people.add(person);
    }
    
    @Override
    public String toString() {
        String str = "calor: " + currentHeat + " Edificio: " + name.toString() + ":\n";
        if(people.size() != 0){
            for (Person p : people){
                str += "\t\tPersona [nombre=" + p.getName() + "]\n";
            }
        } else {
            str += "\t\tNo hay personas\n";
        }
        return str;
    }

    public void plusCurrentHeat(int heat) {
        currentHeat = heat;
    }
}
