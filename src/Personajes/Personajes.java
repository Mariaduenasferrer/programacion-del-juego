package Personajes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Personajes implements Initializable {

    @FXML private TextField textfieldNombre;
    @FXML private Spinner<Integer> spinnerRangoAtaque;
    @FXML private Slider sliderHP;
    @FXML private Slider sliderAtaque;
    @FXML private Slider sliderDefensa;
    @FXML private Spinner<Integer> spinnerRangoMovimiento;
    @FXML private Label labelCategoria;
    @FXML private Label labelHabilidadPredeterminada;

    private Stage scene;
    private String categoria;
    private Propiedades model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        labelCategoria.setText("Categoría: " + categoria);
        cargarModeloSegunCategoria();
    }

    public void setStage(Stage stage) {
        this.scene = stage;
    }

    private void cargarModeloSegunCategoria() {
        Estadisticas parametrosData;
        if ("Ciencias".equals(categoria)) {
            parametrosData = new Estadisticas(120, 5, 3, "Pensamiento Lógico", 15, 7);
        } else {
            parametrosData = new Estadisticas(80, 3, 2, "Creatividad Expresiva", 8, 4);
        }
        model = new Propiedades(parametrosData);
        model.setOriginal(parametrosData);
        labelHabilidadPredeterminada.setText("Habilidad: " + model.getHabilidad());
        vincularControlesConModelo();
    }

    private void vincularControlesConModelo() {
        spinnerRangoAtaque.getValueFactory().valueProperty().bindBidirectional(model.RangoAtaqueProperty().asObject());
        sliderHP.valueProperty().bindBidirectional(model.HPProperty());
        sliderAtaque.valueProperty().bindBidirectional(model.AtaqueProperty());
        sliderDefensa.valueProperty().bindBidirectional(model.DefensaProperty());
        spinnerRangoMovimiento.getValueFactory().valueProperty().bindBidirectional(model.RangoMovimientoProperty().asObject());
    }

    @FXML
    private void onBotonGuardarClick() {
        model.commit();
        System.out.println("Personaje guardado: " + textfieldNombre.getText() + " con categoría " + categoria);
    }

    @FXML
    private void onBotonCerrarClick() {
        if (scene != null) {
            scene.close();
        }
    }
}



