package model;

import java.util.*;
import java.util.stream.Collectors;

public class City {
    private Set<Person> people;
    private int temperature;
    private ArrayList<Circle> circles;
    public City(){
        temperature = 0;
        people = new TreeSet<>();
        circles = new ArrayList<Circle>(){{
            add(new Circle());
            add(new Circle());
            add(new Circle());
            add(new Circle());
            add(new Circle());
        }};
    }
    public boolean addPerson(Person person){
        return people.add(person);
    }
    public void modifyTemperature(int temperatureModifaction){
        this.temperature = this.temperature + temperatureModifaction;
    }

    public ArrayList<Circle> getCircles() {
        return circles;
    }

    public District getDistrictByCircle(int idCircle, int idDistrict){
        return circles.get(idCircle).getDistrict(idDistrict);
    }

    public List<Person> getPeopleSorted() {
        Comparator<Person> compareByCircleAndDistrict = Comparator
                .comparing(Person::getIdCircle)
                .thenComparing(Person::getIdDistrict);

        return people.stream().sorted(compareByCircleAndDistrict).collect(Collectors.toList());
    }

    public int getTemperature() {
        return temperature;
    }
}
