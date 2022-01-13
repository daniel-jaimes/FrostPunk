package model;

import utils.SpecsEdifice;

import java.util.HashSet;
import java.util.Set;

import static utils.SpecsEdifice.name.*;

public class Edifice {
    private String name;
    private int minHeat;
    private int currentHeat;
    private Set<Person> people;
    private Edifice(String name, int currentHeat, int minHeat){
        this.name = name;
        this.currentHeat = currentHeat;
        this.minHeat = minHeat;
        people = new HashSet<>();
    }

    private Edifice() {

    }

    public static Edifice getInstance(SpecsEdifice.name name){
        switch (name){
            case Refugio:
                return new Edifice();
                break;
            case CavanaCaza:
                return new Edifice();
                break;
        }

    }
}
