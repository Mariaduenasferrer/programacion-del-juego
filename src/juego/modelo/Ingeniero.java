package juego.modelo;

public class Ingeniero extends Unidad {

    public Ingeniero(int x, int y) {
        super("Ingeniero", 100, 25, 10, 3, 1); // Nombre, HP, Ataque, Defensa, Movimiento, Rango de ataque
        this.x = x;
        this.y = y;
    }

    @Override
    public String getTipo() {
        return "Ingeniero";
    }
}
