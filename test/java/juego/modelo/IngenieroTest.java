package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IngenieroTest {

    @Test
    void testConstructorYGetTipo() {
        // Crear un ingeniero en la posición (5, 7)
        Ingeniero ingeniero = new Ingeniero(5, 7);

        // Verificar que el nombre es correcto (heredado o definido en Unidad)
        assertEquals("Ingeniero", ingeniero.getNombre());

        // Verificar HP, Ataque, Defensa, Movimiento, RangoAtaque (según lo que envía súper)
        assertEquals(100, ingeniero.getHp());
        assertEquals(25, ingeniero.getAtaque());
        assertEquals(10, ingeniero.getDefensa());
        assertEquals(3, ingeniero.getRangoMovimiento());
        assertEquals(1, ingeniero.getRangoAtaque());

        // Verificar posición x, y
        assertEquals(5, ingeniero.getX());
        assertEquals(7, ingeniero.getY());

        // Verificar método getTipo()
        assertEquals("Ingeniero", ingeniero.getTipo());
    }
}
