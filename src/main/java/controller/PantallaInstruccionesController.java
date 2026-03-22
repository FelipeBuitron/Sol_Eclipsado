package main.java.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PantallaInstruccionesController {

    @FXML
    private Button botonContinuar;

    @FXML
    private void Continuar() throws Exception {
        //Carga la pantalla de juego
        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource("main/resources/view/pantalla_inicio.fxml")
        );

        //Obtiene el controlador de la nueva pantalla
        Parent root = loader.load();
        PantallaInicioController controller = loader.getController();

        Stage stage = (Stage) botonContinuar.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
