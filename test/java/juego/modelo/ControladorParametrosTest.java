package juego.modelo;

import javafx.beans.property.*;
import javafx.scene.control.*;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Personajes.Propiedades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorParametrosTest {

    private ControladorParametros controlador;
    private Propiedades modeloMock;

    @BeforeEach
    void setUp() {
        controlador = new ControladorParametros();

        // Inicializar controles
        controlador.spinnerRangoAtaque = new Spinner<>(new IntegerSpinnerValueFactory(0, 10));
        controlador.sliderHP = new Slider(0, 100, 0);
        controlador.textfieldHabilidad = new TextField();
        controlador.sliderAtaque = new Slider(0, 100, 0);
        controlador.sliderDefensa = new Slider(0, 100, 0);
        controlador.spinnerRangoMovimiento = new Spinner<>(new IntegerSpinnerValueFactory(0, 10));
        controlador.labelCategoria = new Label();

        // Crear propiedades simuladas
        IntegerProperty rangoAtaque = new SimpleIntegerProperty(5);
        DoubleProperty hp = new SimpleDoubleProperty(80);
        StringProperty habilidad = new SimpleStringProperty("Curar");
        DoubleProperty ataque = new SimpleDoubleProperty(20);
        DoubleProperty defensa = new SimpleDoubleProperty(15);
        IntegerProperty rangoMovimiento = new SimpleIntegerProperty(3);


// Crear mock del modelo que devuelve esas propiedades reales
        modeloMock = mock(Propiedades.class);

        doReturn(rangoAtaque).when(modeloMock).RangoAtaqueProperty();
        doReturn(hp).when(modeloMock).HPProperty();
        doReturn(habilidad).when(modeloMock).HabilidadProperty();
        doReturn(ataque).when(modeloMock).AtaqueProperty();
        doReturn(defensa).when(modeloMock).DefensaProperty();
        doReturn(rangoMovimiento).when(modeloMock).RangoMovimientoProperty();


        // Cargar datos en el controlador
        controlador.setCategoria("Ciencias");
        controlador.loadUserData(modeloMock);
    }

    @Test
    void testLoadUserDataYVinculacion() {
        // Modificar el modelo y verificar reflejo en UI
        modeloMock.HPProperty().set(55);
        modeloMock.AtaqueProperty().set(35);
        modeloMock.DefensaProperty().set(25);
        modeloMock.HabilidadProperty().set("Nueva habilidad");

        assertEquals(55, controlador.sliderHP.getValue(), 0.01);
        assertEquals(35, controlador.sliderAtaque.getValue(), 0.01);
        assertEquals(25, controlador.sliderDefensa.getValue(), 0.01);
        assertEquals("Nueva habilidad", controlador.textfieldHabilidad.getText());
        assertEquals(5, controlador.spinnerRangoAtaque.getValue());
        assertEquals(3, controlador.spinnerRangoMovimiento.getValue());
    }

    @Test
    void testSetCategoria() {
        controlador.setCategoria("Letras");
        assertEquals("Categoría: Letras", controlador.labelCategoria.getText());
    }

    @Test
    void testOnBotonGuardarClick() {
        Propiedades modeloSpy = spy(modeloMock);
        controlador.model = modeloSpy;
        controlador.onBotonGuardarClick();
        verify(modeloSpy).commit();
    }

    @Test
    void testOnBotonReiniciarClick() {
        Propiedades modeloSpy = spy(modeloMock);
        controlador.model = modeloSpy;
        controlador.onBotonReiniciarClick();
        verify(modeloSpy).rollback();
    }

    @Test
    void testOnBotonCerrarClick() {
        Stage stageMock = mock(Stage.class);
        controlador.setStage(stageMock);
        controlador.onBotonCerrarClick();
        verify(stageMock).close();
    }
}

