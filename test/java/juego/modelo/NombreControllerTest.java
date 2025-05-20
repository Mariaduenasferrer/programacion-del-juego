package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Personajes.Propiedades;

public class NombreControllerTest {

    private NombreController controller;
    private Stage mockStage;

    @BeforeEach
    void setUp() {
        controller = new NombreController();
        mockStage = mock(Stage.class);
        controller.setStage(mockStage);
    }

    @Test
    void testSetCategoriaCargaModelo() {
        controller.setCategoria("Ciencias");
        Propiedades modeloCiencias = controller.model;
        assertNotNull(modeloCiencias);
        assertEquals("Lógica Avanzada", modeloCiencias.getHabilidad());

        controller.setCategoria("Letras");
        Propiedades modeloLetras = controller.model;
        assertNotNull(modeloLetras);
        assertEquals("Expresión Creativa", modeloLetras.getHabilidad());
    }

}