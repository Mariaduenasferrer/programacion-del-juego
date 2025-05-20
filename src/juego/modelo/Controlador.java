package juego.modelo;

import Personajes.ControladorParametros;
import Personajes.Estadisticas;
import Personajes.Propiedades;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable {
    static int contadorDeVentanasHijas = 0;

    /**
     * Conexiones con controles visuales, marcados con @FXML
     **/
    @FXML
    protected Label welcomeText;
    @FXML
    protected Label labelTextoEjemplo;
    @FXML
    protected Label labelValorSlider;
    @FXML
    protected Slider miSlider;

    /**
     * Propiedades para bindings
     **/
    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medida = new SimpleIntegerProperty(0);

    /**
     * Modelo de datos
     **/
    private final Estadisticas parametrosData = new Estadisticas(100, 4, 2, "Invisibilidad", 10, 5);
    protected final Propiedades modeloParaGUICompartido = new Propiedades(parametrosData);

    /**
     * Métodos de respuesta a eventos
     **/
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        texto.set("Recambiamos una propiedad");
    }

    @FXML
    protected void onMiBotonEjemploClick() {
        welcomeText.setText("Establecemos un texto de ejemplo");
        texto.set("Cambiamos una propiedad!");
    }

    @FXML
    protected String getTexto() {
        return texto.get();
    }

    @FXML
    protected void onMiBotonNuevaVentajaClick() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello! Ventana hija: " + contadorDeVentanasHijas++);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onMiBotonNuevaVentanaParametrosClick() {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parameters-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 420, 340);
            stage.setTitle("Establezca parámetros:");
            stage.setScene(scene);

            ControladorParametros p = fxmlLoader.getController();
            p.loadUserData(modeloParaGUICompartido);
            p.setStage(stage);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicialización en ejecución del controlador");
        labelTextoEjemplo.textProperty().bind(texto);
        miSlider.valueProperty().bindBidirectional(medida);
        labelValorSlider.textProperty().bind(medida.asString());
    }
}



