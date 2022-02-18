package model;

import java.util.*;

public class City {
    private List<Person> people;
    private int temperature;
    private Circle[] circles;
    public City(){
        temperature = 0;
        circles = new Circle[]{
                new Circle(1),
                new Circle(2),

        };
    }
    public void addPerson(Person person){
        people.add(person);
    }
    public void modifyTemperature(int temperatureModifaction){
        this.temperature = this.temperature + temperatureModifaction;
    }
}
