package juego.modelo;

public class Poeta extends Unidad {

    public Poeta(int x, int y) {
        super("Poeta", 80, 30, 5, 4, 2); // Menos vida, más ataque, más rango de movimiento
        this.x = x;
        this.y = y;
    }

    @Override
    public String getTipo() {
        return "Poeta";
    }
}
