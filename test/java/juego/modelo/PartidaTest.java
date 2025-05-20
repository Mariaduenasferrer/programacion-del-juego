package juego.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;


class PartidaTest {

    Partida partida;

    @BeforeEach
    void setUp() {
        partida = new Partida(10, 10);
    }

    @Test
    void getJugadorActual() {
        assertEquals("Jugador 1", partida.getJugadorActual().getNombre());
    }

    @Test
    void pasarTurno() {
        partida.pasarTurno();
        assertEquals("Jugador 2", partida.getJugadorActual().getNombre());
        partida.pasarTurno();
        assertEquals("Jugador 1", partida.getJugadorActual().getNombre());
    }

    @Test
    void haTerminado() {
        assertFalse(partida.haTerminado());

        // Eliminar unidades de jugador2
        var nodo = partida.getJugador2().getUnidades().getCabeza();
        while (nodo != null) {
            nodo.valor.setHp(0);
            nodo = nodo.siguiente;
        }

        assertFalse(partida.haTerminado());
    }

    @Test
    void getGanador() {
        // Simula derrota del jugador2
        var nodo = partida.getJugador2().getUnidades().getCabeza();
        while (nodo != null) {
            nodo.valor.setHp(0);
            nodo = nodo.siguiente;
        }

        assertEquals("Empate", partida.getGanador());

        // Simula derrota del jugador1 también
        nodo = partida.getJugador1().getUnidades().getCabeza();
        while (nodo != null) {
            nodo.valor.setHp(0);
            nodo = nodo.siguiente;
        }

        assertEquals("Empate", partida.getGanador());
    }

    @Test
    void getTablero() {
        assertNotNull(partida.getTablero());
    }

    @Test
    void getJugador1() {
        assertEquals("Jugador 1", partida.getJugador1().getNombre());
    }

    @Test
    void getJugador2() {
        assertEquals("Jugador 2", partida.getJugador2().getNombre());
    }

    @Test
    void guardarPartida() {
        String ruta = "test_guardar_partida.json";
        partida.guardarPartida(ruta);

        File archivo = new File(ruta);
        assertTrue(archivo.exists());

        // Limpieza
        assertTrue(archivo.delete());
    }

    @Test
    void cargarPartida() {
        String ruta = "test_guardar_partida.json";
        partida.guardarPartida(ruta);

        Partida partidaCargada = Partida.cargarPartida(ruta);
        assertNotNull(partidaCargada);

        assertEquals(4, contarUnidades(partidaCargada.getJugador1()));
        assertEquals(4, contarUnidades(partidaCargada.getJugador2()));

        // Limpieza
        assertTrue(new File(ruta).delete());
    }

    @Test
    void exportarUnidades() {
        List<UnidadSerializable> lista = partida.exportarUnidades(partida.getJugador1());
        assertEquals(2, lista.size());
        assertEquals("Ingeniero", lista.getFirst().tipo);
    }

    @Test
    void cargarUnidades() {
        List<UnidadSerializable> lista = partida.exportarUnidades(partida.getJugador1());

        Jugador jugadorNuevo = new Jugador("Nuevo");
        partida.cargarUnidades(lista, jugadorNuevo);

        assertEquals(2, contarUnidades(jugadorNuevo));
    }

    private int contarUnidades(Jugador jugador) {
        int count = 0;
        var nodo = jugador.getUnidades().getCabeza();
        while (nodo != null) {
            count++;
            nodo = nodo.siguiente;
        }
        return count;
    }
}
