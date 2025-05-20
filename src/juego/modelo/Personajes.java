package juego.modelo;

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

    @FXML protected TextField textfieldNombre;
    @FXML protected Spinner<Integer> spinnerRangoAtaque;
    @FXML protected Slider sliderHP;
    @FXML protected Slider sliderAtaque;
    @FXML protected Slider sliderDefensa;
    @FXML protected Spinner<Integer> spinnerRangoMovimiento;
    @FXML protected Label labelCategoria;
    @FXML protected Label labelHabilidadPredeterminada;

    private Stage scene;
    protected String categoria;
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
        Unidad parametrosData;
        parametrosData = new Unidad("Pensamiento Lógico", 5, 3, 120, 15, 7) {

            @Override
            public String getTipo() {
                return "";
            }
        };
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
    protected void onBotonGuardarClick() {
        model.commit();
        System.out.println("Personaje guardado: " + textfieldNombre.getText() + " con categoría " + categoria);
    }

    @FXML
    protected void onBotonCerrarClick() {
        if (scene != null) {
            scene.close();
        }
    }
}



