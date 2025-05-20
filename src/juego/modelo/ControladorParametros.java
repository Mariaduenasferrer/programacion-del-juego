package juego.modelo;

import Personajes.Propiedades;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorParametros implements Initializable {

    @FXML protected Spinner<Integer> spinnerRangoAtaque;
    @FXML protected Slider sliderHP;
    @FXML protected TextField textfieldHabilidad;
    @FXML protected Slider sliderAtaque;
    @FXML protected Slider sliderDefensa;
    @FXML protected Spinner<Integer> spinnerRangoMovimiento;
    @FXML protected Label labelCategoria;

    protected Stage scene;
    protected String categoria;
    protected Propiedades model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        if (labelCategoria != null) {
            labelCategoria.setText("Categoría: " + categoria);
        }
    }

    public void setStage(Stage stage) {
        this.scene = stage;
    }

    public void loadUserData(Propiedades model) {
        this.model = model;
        vincularControlesConModelo();
        if (labelCategoria != null && categoria != null) {
            labelCategoria.setText("Categoría: " + categoria);
        }
    }

    protected void vincularControlesConModelo() {
        spinnerRangoAtaque.getValueFactory().valueProperty().bindBidirectional(model.RangoAtaqueProperty().asObject());
        sliderHP.valueProperty().bindBidirectional(model.HPProperty());
        textfieldHabilidad.textProperty().bindBidirectional(model.HabilidadProperty());
        sliderAtaque.valueProperty().bindBidirectional(model.AtaqueProperty());
        sliderDefensa.valueProperty().bindBidirectional(model.DefensaProperty());
        spinnerRangoMovimiento.getValueFactory().valueProperty().bindBidirectional(model.RangoMovimientoProperty().asObject());
    }

    @FXML
    protected void onBotonGuardarClick() {
        model.commit();
        System.out.println("Datos guardados para categoría: " + categoria);
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
    }

    @FXML
    protected void onBotonCerrarClick() {
        if (scene != null) {
            scene.close();
        }
    }
}



