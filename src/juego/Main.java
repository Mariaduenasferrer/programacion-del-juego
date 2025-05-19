package juego;
import juego.modelo.Jugador;
import juego.modelo.Ingeniero;
import juego.modelo.Poeta;
import juego.modelo.Tablero;
import juego.modelo.Casilla;
import juego.estructuras.Cola;
import juego.modelo.Partida;




public class Main {
    public static void main(String[] args) {
        System.out.println("¡Proyecto creado correctamente!");

        Jugador j1 = new Jugador("Jugador 1");
        j1.agregarUnidad(new Ingeniero(0, 0));
        j1.agregarUnidad(new Poeta(1, 1));
        System.out.println(j1.getNombre() + " tiene unidades vivas: " + j1.tieneUnidadesVivas());
        Tablero tablero = new Tablero(10, 10);
        Casilla c = tablero.getCasilla(2, 3);

        if (!c.estaOcupada()) {
            Ingeniero ing = new Ingeniero(2, 3);
            c.ocupar(ing);
            System.out.println("Unidad colocada en " + c.getX() + "," + c.getY());
        }
        Cola<Jugador> colaTurnos = new Cola<>();

        Jugador j1Copia = new Jugador("Jugador 1");
        Jugador j2 = new Jugador("Jugador 2");

        colaTurnos.encolar(j1Copia);
        colaTurnos.encolar(j2);

// Empieza el juego
        for (int i = 0; i < 4; i++) {
            Jugador actual = colaTurnos.desencolar();
            System.out.println("Turno de: " + actual.getNombre());
            colaTurnos.encolar(actual); // Lo metes de nuevo al final para seguir el ciclo
        }
        Ingeniero atacante = new Ingeniero(2, 3);
        Poeta objetivo = new Poeta(3, 3); // Está a 1 de distancia (rango válido)

        System.out.println("HP del objetivo antes del ataque: " + objetivo.getHp());

        if (atacante.puedeAtacarA(objetivo)) {
            atacante.atacar(objetivo);
        } else {
            System.out.println("El objetivo está fuera de rango.");
        }

        System.out.println("HP del objetivo después del ataque: " + objetivo.getHp());


        Ingeniero ing = new Ingeniero(2, 3);
        tablero.getCasilla(2, 3).ocupar(ing);

        // Intentamos mover al Ingeniero
        boolean movido = tablero.moverUnidad(ing, 3, 4);

        System.out.println("¿Movimiento exitoso? " + movido);
        System.out.println("Posición actual: " + ing.getX() + "," + ing.getY());

        Partida partida = new Partida(10, 10);

        System.out.println("Turno actual: " + partida.getJugadorActual().getNombre());
        partida.pasarTurno();
        System.out.println("Turno actual: " + partida.getJugadorActual().getNombre());

        System.out.println("¿La partida ha terminado? " + partida.haTerminado());

        Partida partidaOriginal = new Partida(10, 10);

        // Guardar la partida en un archivo
        partidaOriginal.guardarPartida("partida_guardada.json");

        // Cargar la partida desde ese archivo
        Partida partidaCargada = Partida.cargarPartida("partida_guardada.json");

        // Mostrar el turno actual tras cargar
        if (partidaCargada != null) {
            System.out.println("Turno actual tras cargar: " + partidaCargada.getJugadorActual().getNombre());
        }
    }


    }






