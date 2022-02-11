package model;

public class District {
    private Integer id;
    private Edifice edifice;
    public District(){
        edifice = null;
    }

    public void setEdificeIfNull(Edifice edifice) {
        if (this.edifice == null) this.edifice = edifice;
    }
}
