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

/**
 * CONTROLADOR DE LA PANTALLA DE INICIO DEL JUEGO
 * Se encarga de recibir la palabra ingresada por el jugador y validarla para iniciar el juego
 *
 * @author Andrés Felipe Escobar
 * @author Carlos Enrique Delgado
 * @version 1.0
 */

public class PantallaInicioController {

    @FXML
    private TextField campoPalabra;

    @FXML
    private Button botonJugar;

    /**
     * Método que se ejecuta al presionar el botón Jugar.
     * Obtiene la palabra ingresada, la valida y, si es correcta, carga la pantalla del juego.
     */
    @FXML
    private void jugar() {
        //Obtener la palabra secreta ingresada
        String palabra = campoPalabra.getText();

        //Validar la palabra usando la clase ValidadorPalabra
        if (!ValidadorPalabra.palabraValida(palabra)) {

            //Muestra el error si la palabra no es válida
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("La palabra ingresada debe ser una sola palabra, sin espacios intermedios ni finales. \nLa palabra debe tener entre 6 y 12 letras.");

            alerta.showAndWait();

        } else {

            try {
                //Carga la pantalla de juego
                FXMLLoader loader = new FXMLLoader(
                        getClass().getClassLoader().getResource("main/resources/view/pantalla_juego.fxml")
                );
                Parent root = loader.load();

                //Obtiene el controlador de la nueva pantalla
                PantallaJuegoController controller = loader.getController();

                //Envía la palabra al juego
                controller.iniciarJuego(palabra);

                //Cambia de escena
                Stage stage = (Stage) botonJugar.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}