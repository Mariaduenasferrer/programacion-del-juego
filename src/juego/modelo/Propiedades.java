package juego.modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Propiedades {
    protected Unidad original;

    protected final IntegerProperty HP = new SimpleIntegerProperty();
    protected final IntegerProperty RangoAtaque = new SimpleIntegerProperty();
    protected final IntegerProperty RangoMovimiento = new SimpleIntegerProperty();
    protected final IntegerProperty Ataque = new SimpleIntegerProperty();
    protected final IntegerProperty Defensa = new SimpleIntegerProperty();
    protected final StringProperty Habilidad = new SimpleStringProperty();

    public Propiedades(Unidad parametrosData) {
        this.original = parametrosData;
        rollback();
    }

    public void commit() {
        original.setHp(HP.get());
        original.setRangoAtaque(RangoAtaque.get());
        original.setRangoMovimiento(RangoMovimiento.get());
        original.setAtaque(Ataque.get());
        original.setDefensa(Defensa.get());
        original.setHabilidad(Habilidad.get());
    }

    public void rollback() {
        HP.set(original.getHp());
        RangoAtaque.set(original.getRangoAtaque());
        RangoMovimiento.set(original.getRangoMovimiento());
        Ataque.set(original.getAtaque());
        Defensa.set(original.getDefensa());
        Habilidad.set(original.getHabilidad());
    }

    public IntegerProperty HPProperty() { return HP; }
    public IntegerProperty RangoAtaqueProperty() { return RangoAtaque; }
    public IntegerProperty RangoMovimientoProperty() { return RangoMovimiento; }
    public IntegerProperty AtaqueProperty() { return Ataque; }
    public IntegerProperty DefensaProperty() { return Defensa; }
    public StringProperty HabilidadProperty() { return Habilidad; }

    public void setOriginal(Unidad parametrosData) {
    }
    public String getHabilidad() {
        return Habilidad.get();
    }
}

