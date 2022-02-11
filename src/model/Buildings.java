package model;

import static model.Buildings.name.*;

public class Buildings {
    enum name {
        REFUGIO, COCINA, ASERRADERO, CAVANA_CAZA, MINA_CARBON, MOTOR_VAPOR
    }
    public static Edifice makeEdifice(String nameEdifice){
        switch (Buildings.name.valueOf(nameEdifice)){
            case REFUGIO:
                return new Edifice(REFUGIO, 1, 1);
            case COCINA:
                return new Edifice(COCINA, 0, 1);
            case ASERRADERO:
                return new Edifice(ASERRADERO, -2, 0);
            case CAVANA_CAZA:
                return new Edifice(CAVANA_CAZA, -2, 0);
            case MINA_CARBON:
                return new Edifice(MINA_CARBON, -2, 0);
            case MOTOR_VAPOR:
                return new Edifice(MOTOR_VAPOR, -5, 3);
            default:
                return null;
        }
    }

}
