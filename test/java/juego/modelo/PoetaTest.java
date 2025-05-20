package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PoetaTest {

    @Test
    public void testConstructorYGetters() {
        Poeta poeta = new Poeta(3, 7);

        // Verifica tipo
        assertEquals("Poeta", poeta.getTipo());

        // Verifica atributos iniciales (según llamada al súper en el constructor)
        assertEquals(80, poeta.getHp());
        assertEquals(30, poeta.getAtaque());
        assertEquals(2, poeta.getRangoAtaque());
        assertEquals(4, poeta.getRangoMovimiento());
        assertEquals(5, poeta.getDefensa());

        // Verifica coordenadas
        assertEquals(3, poeta.getX());
        assertEquals(7, poeta.getY());
    }
}
