package model;

import java.util.*;

public class City {
    private List<Person> people;
    private int temperature;
    private ArrayList<Circle> circles;
    public City(){
        temperature = 0;
        circles = new ArrayList<Circle>(){{
            add(new Circle());
            add(new Circle());
            add(new Circle());
            add(new Circle());
            add(new Circle());
        }};
    }
    public void addPerson(Person person){
        people.add(person);
    }
    public void modifyTemperature(int temperatureModifaction){
        this.temperature = this.temperature + temperatureModifaction;
    }
    public Circle getCircle(int id){
        return circles.get(id);
    }
}
