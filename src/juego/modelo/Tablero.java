package juego.modelo;

public class Tablero {
    private int filas;
    private int columnas;
    private Casilla[][] casillas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casillas = new Casilla[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Por ahora todos con coste 1 y defensa 0
                casillas[i][j] = new Casilla(i, j, 1, 0);
            }
        }
    }

    public Casilla getCasilla(int x, int y) {
        if (x < 0 || x >= filas || y < 0 || y >= columnas) return null;
        return casillas[x][y];
    }

    public boolean estaDentroDelTablero(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }

    public boolean moverUnidad(Unidad unidad, int destinoX, int destinoY) {
        if (!estaDentroDelTablero(destinoX, destinoY)) return false;

        Casilla origen = getCasilla(unidad.getX(), unidad.getY());
        Casilla destino = getCasilla(destinoX, destinoY);

        if (destino.estaOcupada()) return false;
        if (!unidad.puedeMoverA(destinoX, destinoY)) return false;

        origen.liberar();
        destino.ocupar(unidad);
        unidad.moverA(destinoX, destinoY);

        System.out.println(unidad.getNombre() + " se mueve a (" + destinoX + "," + destinoY + ")");
        return true;
    }

}
