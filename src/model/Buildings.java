package model;


import exceptions.LogicException;

public enum Buildings {
    REFUGIO(1, 1), COCINA(0, 1), ASERRADERO(-2, 0),
    CAVANA_CAZA(-2, 0), MINA_CARBON(-2, 0), MOTOR_VAPOR(-5, 3),
    PUESTO_MEDICO(1, 1);

    private int minHeat;
    private int initalHeat;

    Buildings(int minHeat, int initalHeat) {
        this.minHeat = minHeat;
        this.initalHeat = initalHeat;
    }

    public static Edifice makeEdifice(String typeEdifice) throws LogicException {
        switch (Buildings.valueOf(typeEdifice.toUpperCase())){
            case REFUGIO:
                return new Edifice(REFUGIO, REFUGIO.initalHeat, REFUGIO.minHeat);
            case COCINA:
                return new Edifice(COCINA, COCINA.initalHeat, COCINA.minHeat);
            case ASERRADERO:
                return new Edifice(ASERRADERO, ASERRADERO.initalHeat, ASERRADERO.minHeat);
            case CAVANA_CAZA:
                return new Edifice(CAVANA_CAZA, CAVANA_CAZA.initalHeat, CAVANA_CAZA.minHeat);
            case MINA_CARBON:
                return new Edifice(MINA_CARBON, MINA_CARBON.initalHeat, MINA_CARBON.minHeat);
            case MOTOR_VAPOR:
                return new Edifice(MOTOR_VAPOR, MOTOR_VAPOR.initalHeat, MOTOR_VAPOR.minHeat);
            case PUESTO_MEDICO:
                return new Edifice(PUESTO_MEDICO, PUESTO_MEDICO.initalHeat, PUESTO_MEDICO.minHeat);
            default:
                throw new LogicException(LogicException.INCORRECT_NAME_EDIFICE);
        }
    }

}
