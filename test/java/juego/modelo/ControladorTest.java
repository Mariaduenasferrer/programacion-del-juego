package juego.modelo;

import javafx.application.Application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


class ControladorTest extends Application {
    private Controlador controlador;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
        controlador = fxmlLoader.getController();
    }

    @BeforeEach
    void setUp() {
        controlador.texto.set("Texto inicial");
        controlador.medida.set(50);
    }

    @Test
    void testOnHelloButtonClick() {
        controlador.onHelloButtonClick();
        assertEquals("Recambiamos una propiedad", controlador.getTexto());
    }

    @Test
    void testOnMiBotonEjemploClick() {
        controlador.onMiBotonEjemploClick();
        assertEquals("Cambiamos una propiedad!", controlador.getTexto());
    }

    @Test
    void testOnMiBotonNuevaVentajaClick() {
        controlador.onMiBotonNuevaVentajaClick();
        assertTrue(Controlador.contadorDeVentanasHijas > 0);
    }

    @Test
    void testOnMiBotonNuevaVentanaParametrosClick() {
        controlador.onMiBotonNuevaVentanaParametrosClick();
        assertNotNull(controlador.modeloParaGUICompartido);
    }

    @Test
    void testBindings() {
        controlador.medida.set(30);
        assertEquals("30", controlador.labelValorSlider.getText());
    }
}
