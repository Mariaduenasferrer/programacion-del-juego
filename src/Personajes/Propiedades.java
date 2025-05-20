package Personajes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Propiedades {
    protected Estadisticas original;

    private final IntegerProperty HP = new SimpleIntegerProperty();
    private final IntegerProperty RangoAtaque = new SimpleIntegerProperty();
    private final IntegerProperty RangoMovimiento = new SimpleIntegerProperty();
    private final IntegerProperty Ataque = new SimpleIntegerProperty();
    private final IntegerProperty Defensa = new SimpleIntegerProperty();
    private final StringProperty Habilidad = new SimpleStringProperty();

    public Propiedades(Estadisticas parametrosData) {
        this.original = parametrosData;
        rollback();
    }

    public void commit() {
        original.setHP(HP.get());
        original.setRangoAtaque(RangoAtaque.get());
        original.setRangoMovimiento(RangoMovimiento.get());
        original.setAtaque(Ataque.get());
        original.setDefensa(Defensa.get());
        original.setHabilidad(Habilidad.get());
    }

    public void rollback() {
        HP.set(original.getHP());
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

    public void setOriginal(Estadisticas parametrosData) {
    }
    public String getHabilidad() {
        return Habilidad.get();
    }
}

