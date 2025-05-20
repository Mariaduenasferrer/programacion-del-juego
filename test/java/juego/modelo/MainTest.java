package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import juego.modelo.Partida;

import java.nio.file.Files;
import java.nio.file.Path;

public class MainTest {

    @Test
    void testGuardarYCargarPartida() throws Exception {
        // Crear partida
        Partida partida = new Partida(10, 10);

        // Archivo temporal
        Path tempFile = Files.createTempFile("partida_test", ".json");
        String rutaArchivo = tempFile.toString();

        // Guardar partida
        partida.guardarPartida(rutaArchivo);

        // Cargar partida
        Partida partidaCargada = Partida.cargarPartida(rutaArchivo);

        // Verificar que no es null
        assertNotNull(partidaCargada);

        // Verificar que el nombre del jugador actual coincide
        assertEquals(partida.getJugadorActual().getNombre(), partidaCargada.getJugadorActual().getNombre());

        // Eliminar archivo temporal (opcional)
        Files.deleteIfExists(tempFile);
    }
}
