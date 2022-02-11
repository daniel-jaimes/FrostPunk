package model;

import java.util.TreeSet;

public class Circle {
    private int id;
    private TreeSet<District> district;
    protected Circle(int id){
        this.id = id;
        this.district = null;
    }
}
