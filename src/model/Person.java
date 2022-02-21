package model;

public class Person implements Comparable<Person>{
    private String name;
    private Integer idCircle;
    private Integer idDistrict;
    private boolean sick;
    private boolean busy;

    @Override
    public String toString() {
        return "Person [" +
                "nombre=" + name +
                ", circle=" + idCircle +
                ", distrito=" + idDistrict +
                ']';
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
