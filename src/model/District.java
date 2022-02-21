package model;

import exceptions.LogicException;

public class District {
    private Edifice edifice;
    public District(){
        edifice = null;
    }
    public void setEdificeIfNull(Edifice edifice) throws LogicException {
        if (this.edifice == null) {
            this.edifice = edifice;
            throw new LogicException(LogicException.EDIFICE_CORRECTED_ADDED);
        } else {
            throw new LogicException(LogicException.PLOT_IS_NOT_EMPTY);
        }
    }
}
