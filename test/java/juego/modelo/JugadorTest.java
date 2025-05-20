package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    private Jugador jugador;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Juan");
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Juan", jugador.getNombre());
        assertNotNull(jugador.getUnidades());
        assertFalse(jugador.tieneUnidadesVivas()); // Sin unidades, no hay vivas
    }

    @Test
    void testAgregarUnidadYTieneUnidadesVivas() {
        Unidad unidadMock = mock(Unidad.class);
        when(unidadMock.estaViva()).thenReturn(true);

        jugador.agregarUnidad(unidadMock);
        assertTrue(jugador.tieneUnidadesVivas());
        assertTrue(jugador.getUnidades().contiene(unidadMock)); // Asumiendo método contiene()
    }

    @Test
    void testEliminarUnidadYTieneUnidadesVivas() {
        Unidad unidadMock = mock(Unidad.class);
        when(unidadMock.estaViva()).thenReturn(true);

        jugador.agregarUnidad(unidadMock);
        assertTrue(jugador.tieneUnidadesVivas());

        jugador.eliminarUnidad(unidadMock);
        assertFalse(jugador.tieneUnidadesVivas());
        assertFalse(jugador.getUnidades().contiene(unidadMock)); // Asumiendo método contiene()
    }

    @Test
    void testTieneUnidadesVivasConUnidadesMuertas() {
        Unidad unidadViva = mock(Unidad.class);
        Unidad unidadMuerta = mock(Unidad.class);

        when(unidadViva.estaViva()).thenReturn(true);
        when(unidadMuerta.estaViva()).thenReturn(false);

        jugador.agregarUnidad(unidadMuerta);
        jugador.agregarUnidad(unidadViva);

        assertTrue(jugador.tieneUnidadesVivas());

        // Ahora matar la unidad viva
        when(unidadViva.estaViva()).thenReturn(false);

        assertFalse(jugador.tieneUnidadesVivas());
    }
}
