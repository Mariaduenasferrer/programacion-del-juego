package juego.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.control.Spinner;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

class PersonajesTest {
    private Personajes personajes;

    @BeforeEach
    void setUp() {
        personajes = new Personajes();
        personajes.textfieldNombre = new TextField();
        personajes.spinnerRangoAtaque = new Spinner<>(1, 10, 5);
        personajes.sliderHP = new Slider(0, 200, 100);
        personajes.sliderAtaque = new Slider(0, 50, 25);
        personajes.sliderDefensa = new Slider(0, 50, 25);
        personajes.spinnerRangoMovimiento = new Spinner<>(1, 10, 5);
        personajes.labelCategoria = new Label();
        personajes.labelHabilidadPredeterminada = new Label();
    }

    @Test
    void testSetCategoria() {
        personajes.setCategoria("Guerrero");
        assertEquals("Guerrero", personajes.categoria);
        assertEquals("Categoría: Guerrero", personajes.labelCategoria.getText());
    }

    @Test
    void testOnBotonGuardarClick() {
        personajes.textfieldNombre.setText("Héroe");
        personajes.setCategoria("Mago");
        personajes.onBotonGuardarClick();
        assertEquals("Héroe", personajes.textfieldNombre.getText());
        assertEquals("Mago", personajes.categoria);
    }
}

