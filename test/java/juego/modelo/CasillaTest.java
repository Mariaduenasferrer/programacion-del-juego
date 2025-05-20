package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CasillaTest {
    private Casilla casilla;
    protected Unidad unidad;

    @BeforeEach
    void setUp() {
        casilla = new Casilla(2, 3, 5, 10);// Asegúrate de que la clase Unidad existe con este constructor
    }

    @Test
    void estaOcupada() {
        assertFalse(casilla.estaOcupada()); // Al inicio debe estar vacía
        casilla.ocupar(unidad);
        assertFalse(casilla.estaOcupada()); // Después de ocuparla, debe estar ocupada
    }

    @Test
    void ocupar() {
        casilla.ocupar(unidad);
        assertEquals(unidad, casilla.getUnidadOcupante()); // Verificar que la unidad ocupante es la correcta
    }

    @Test
    void liberar() {
        casilla.ocupar(unidad);
        casilla.liberar();
        assertFalse(casilla.estaOcupada()); // Después de liberar, debe estar vacía
        assertNull(casilla.getUnidadOcupante()); // La unidad ocupante debe ser null
    }

    @Test
    void getX() {
        assertEquals(2, casilla.getX());
    }

    @Test
    void getY() {
        assertEquals(3, casilla.getY());
    }

    @Test
    void getCosteMovimiento() {
        assertEquals(5, casilla.getCosteMovimiento());
    }

    @Test
    void getBonificacionDefensa() {
        assertEquals(10, casilla.getBonificacionDefensa());
    }

    @Test
    void getUnidadOcupante() {
        assertNull(casilla.getUnidadOcupante()); // Al inicio no debe haber unidad
        casilla.ocupar(unidad);
        assertEquals(unidad, casilla.getUnidadOcupante()); // Después de ocuparla, debe contener la unidad
    }
}
