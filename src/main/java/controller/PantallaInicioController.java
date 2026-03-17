package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import main.java.model.ValidadorPalabra;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PantallaInicioController {

    @FXML
    private TextField campoPalabra;

    @FXML
    private Button botonJugar;

    @FXML
    private void jugar() {

        String palabra = campoPalabra.getText();

        if(!ValidadorPalabra.palabraValida(palabra)){

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("La palabra debe tener entre 6 y 12 letras.");

            alerta.showAndWait();

        } else {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pantalla_juego.fxml"));
                System.out.println(getClass().getResource("/view/pantalla_juego.fxml"));
                Parent root = loader.load();

                PantallaJuegoController controller = loader.getController();
                controller.iniciarJuego(palabra);

                Stage stage = (Stage) botonJugar.getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}