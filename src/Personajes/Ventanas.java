package Personajes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ventanas extends Application {



    @Override
    public void start(Stage primaryStage) {
        Button btnCiencias = new Button("Ciencias");
        Button btnLetras = new Button("Letras");

        btnCiencias.setOnAction(e -> abrirVentanaNombre("Ciencias"));
        btnLetras.setOnAction(e -> abrirVentanaNombre("Letras"));

        VBox root = new VBox(20, btnCiencias, btnLetras);
        root.setStyle("-fx-padding: 30; -fx-alignment: center;");

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setTitle("Selecciona tu tipo de personaje");
        primaryStage.show();
    }



    protected void abrirVentanaNombre(String categoria) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demojavafx/nombre-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            NombreController controller = loader.getController();
            controller.setCategoria(categoria);
            controller.setStage(stage);

            stage.setTitle("Introduce tu nombre");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onNuevaPartidaButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("options.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 500, 500));

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Options");
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}





