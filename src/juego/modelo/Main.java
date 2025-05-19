package juego.modelo;

import juego.modelo.Partida;

public class Main {
    public static void main(String[] args) {
        Partida partida = new Partida(10, 10);

        // Guardar
        partida.guardarPartida("partida_guardada.json");

        // Cargar
        Partida partidaCargada = Partida.cargarPartida("partida_guardada.json");

        if (partidaCargada != null) {
            System.out.println("Turno actual tras cargar: " + partidaCargada.getJugadorActual().getNombre());
        }
    }
}

