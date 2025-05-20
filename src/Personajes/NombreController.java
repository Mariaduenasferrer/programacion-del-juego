package Personajes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NombreController {

    @FXML private TextField textfieldNombre;
    @FXML private Button botonEstadisticas;

    private Stage stage;
    private String categoria;
    private Propiedades model;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        cargarModeloPorCategoria();
    }

    private void cargarModeloPorCategoria() {
        Estadisticas data = categoria.equals("Ciencias") ?
                new Estadisticas(120, 5, 3, "Lógica Avanzada", 15, 7) :
                new Estadisticas(80, 3, 2, "Expresión Creativa", 8, 4);

        model = new Propiedades(data);
    }

    @FXML
    private void onBotonEstadisticasClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/estadisticas-view.fxml"));
            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(loader.load()));

            ControladorParametros controller = loader.getController();
            controller.setCategoria(categoria);
            controller.loadUserData(model);
            controller.setStage(nuevaVentana);

            nuevaVentana.setTitle("Estadísticas de " + textfieldNombre.getText());
            nuevaVentana.show();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

