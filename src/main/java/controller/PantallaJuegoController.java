package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.model.Juego;

public class PantallaJuegoController {

    @FXML
    private HBox contenedorLetras;

    @FXML
    private ImageView imagenSol;

    @FXML
    private TextField campoLetra;

    @FXML
    private Button botonAyuda;

    private Juego juego;
    private int posicionActual = 0;

    private final int MAX_ERRORES = 5;

    @FXML
    private void escribirLetra() {

        String texto = campoLetra.getText();

        if (texto.length() == 1) {

            char letra = texto.charAt(0);

            boolean correcta = juego.verificarLetra(posicionActual, letra);

            if (correcta) {

                Label letraLabel = (Label) contenedorLetras.getChildren().get(posicionActual);
                letraLabel.setText(String.valueOf(letra));

                posicionActual++;

                // 🔥 VERIFICAR SI GANÓ
                if (posicionActual == juego.getPalabraSecreta().length()) {
                    mostrarMensaje("¡Ganaste!");
                    bloquearJuego();
                }

            } else {

                actualizarSol(juego.getErrores());

                // 🔥 VERIFICAR SI PERDIÓ
                if (juego.getErrores() >= MAX_ERRORES) {
                    mostrarMensaje("Perdiste \nLa palabra era: " + juego.getPalabraSecreta());
                    bloquearJuego();
                }
            }

            campoLetra.clear();
        }
    }

    public void iniciarJuego(String palabra) {

        juego = new Juego(palabra);

        posicionActual = 0;

        actualizarSol(0);

        contenedorLetras.getChildren().clear();

        for (int i = 0; i < palabra.length(); i++) {
            Label guion = new Label("_");
            guion.setStyle("-fx-font-size: 25px;");
            contenedorLetras.getChildren().add(guion);
        }
    }

    private void actualizarSol(int errores) {

        String ruta = "file:D:/JavaProjects/SolEclipsado/src/main/resources/img/sol" + errores + ".png";
        Image imagen = new Image(ruta);
        imagenSol.setImage(imagen);
    }

    @FXML
    private void usarAyuda() {

        int posicion = juego.usarAyuda();

        if (posicion != -1) {

            char letraCorrecta = juego.getPalabraSecreta().charAt(posicion);

            Label letraLabel = (Label) contenedorLetras.getChildren().get(posicion);
            letraLabel.setText(String.valueOf(letraCorrecta));

            if (posicion == posicionActual) {
                posicionActual++;
            }

        } else {
            botonAyuda.setDisable(true);
        }
    }

    // 🔥 MOSTRAR MENSAJE
    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    // 🔥 BLOQUEAR EL JUEGO
    private void bloquearJuego() {
        campoLetra.setDisable(true);
        botonAyuda.setDisable(true);
    }
}