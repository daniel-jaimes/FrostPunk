package model;

import java.util.Set;

public class City {
    private Set<Person> people;
    private int temperature;
    public City(){
        temperature = 0;
    }
    public void addPerson(Person person){
        people.add(person);
    }
}
