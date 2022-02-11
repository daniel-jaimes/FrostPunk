package model;

public class Person {
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
}
