package juego.modelo;

public class Casilla {
    private int x, y;
    private int costeMovimiento;
    private int bonificacionDefensa;
    private Unidad unidadOcupante; // null si está vacía

    public Casilla(int x, int y, int costeMovimiento, int bonificacionDefensa) {
        this.x = x;
        this.y = y;
        this.costeMovimiento = costeMovimiento;
        this.bonificacionDefensa = bonificacionDefensa;
        this.unidadOcupante = null;
    }

    public boolean estaOcupada() {
        return unidadOcupante != null;
    }

    public void ocupar(Unidad u) {
        this.unidadOcupante = u;
    }

    public void liberar() {
        this.unidadOcupante = null;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getCosteMovimiento() { return costeMovimiento; }
    public int getBonificacionDefensa() { return bonificacionDefensa; }
    public Unidad getUnidadOcupante() { return unidadOcupante; }
}

