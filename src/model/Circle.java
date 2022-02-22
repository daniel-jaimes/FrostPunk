package model;

import java.util.ArrayList;

public class Circle {
    private ArrayList<District> districts;
    protected Circle(){
        this.districts = new ArrayList<District>(){{
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
            add(new District());
        }};
    }
    protected District getDistrict(int id){
        return districts.get(id - 1);
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }
}
