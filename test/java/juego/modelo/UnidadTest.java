package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnidadTest {
    private Unidad unidadA;
    private Unidad unidadB;

    @BeforeEach
    void setUp() {
        unidadA = new Unidad("Guerrero", 100, 20, 5, 3, 1) {
            @Override
            public String getTipo() {
                return "Guerrero";
            }
        };

        unidadB = new Unidad("Arquero", 80, 15, 3, 2, 3) {
            @Override
            public String getTipo() {
                return "Arquero";
            }
        };

        unidadA.moverA(0, 0);
        unidadB.moverA(1, 1);
    }

    @Test
    void testMovimiento() {
        assertFalse(unidadA.puedeMoverA(2, 2));
        assertFalse(unidadA.puedeMoverA(5, 5));
    }

    @Test
    void testRecibirDanio() {
        unidadA.recibirDanio(30);
        assertEquals(70, unidadA.getHp());
    }

    @Test
    void testEstaViva() {
        unidadA.recibirDanio(100);
        assertFalse(unidadA.estaViva());
    }

    @Test
    void testAtaqueEnRango() {
        unidadA.moverA(1, 1);
        assertTrue(unidadA.puedeAtacarA(unidadB));
    }

    @Test
    void testAtaqueFueraDeRango() {
        unidadA.moverA(5, 5);
        assertFalse(unidadA.puedeAtacarA(unidadB));
    }
}
