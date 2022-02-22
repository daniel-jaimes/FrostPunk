package model;

public class Person implements Comparable<Person>{
    private String name;
    private int idCircle;
    private int idDistrict;
    private boolean sick;
    private boolean busy;
    public Person(String name){
        this.name = name;
        busy = false;
        sick = false;
    }
    public Person(String name, int idCircle, int idDistrict){
        this(name);
        this.idCircle = idCircle;
        this.idDistrict = idDistrict;
    }
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

    protected int getIdCircle() {
        return idCircle;
    }

    protected int getIdDistrict() {
        return idDistrict;
    }

    public String getName() {
        return name;
    }

    public boolean isSick() {
        return sick;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setSick(boolean sick) {
        this.sick = sick;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
