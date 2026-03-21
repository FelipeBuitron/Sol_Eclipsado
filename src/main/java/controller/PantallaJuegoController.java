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

/**
 * CONTROLADOR DE LA PANTALLA PRINCIPAL DEL JUEGO
 * Gestiona la logica del juego, como ingresar letras, usar ayudas
 * actualizar la interfaz y verificar si el jugador gana o pierde
 *
 * @author Andrés Felipe Escobar
 * @author Carlos Enrique Delgado
 * @version 1.0
 */

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

    /**
     * Metodo que verifica si la letra es corecta, actualiza la interfaz
     * y determina si el jugador gana  o pierde
     */
    @FXML
    private void escribirLetra() {

        String texto = campoLetra.getText();

        //Validación de solo un caracter
        if (texto.length() == 1) {

            char letra = texto.charAt(0);

            //Verifica si la letra es correcta en la posición actual
            boolean correcta = juego.verificarLetra(posicionActual, letra);

            if (correcta) {

                //Muestra la letra correcta en pantalla
                Label letraLabel = (Label) contenedorLetras.getChildren().get(posicionActual);
                letraLabel.setText(String.valueOf(letra));

                posicionActual++;

                // Verifica si el jugador ganó
                if (posicionActual == juego.getPalabraSecreta().length()) {
                    mostrarMensaje("¡Ganaste!");
                    bloquearJuego();
                }

            } else {
                //Actualiza la imagen del son segun los errores
                actualizarSol(juego.getErrores());

                // Verifica si el jugador perdió
                if (juego.getErrores() >= MAX_ERRORES) {
                    mostrarMensaje("Perdiste \nLa palabra era: " + juego.getPalabraSecreta());
                    bloquearJuego();
                }
            }

            campoLetra.clear();
        }
    }

    /**
     * Inicia el juego con la palabra secreta.
     * @param palabra (palabra que el jugador debe adivinar)
     */
    public void iniciarJuego(String palabra) {

        juego = new Juego(palabra);

        posicionActual = 0;

        actualizarSol(0); //Estado inicial del sol

        contenedorLetras.getChildren().clear(); //Limpia el conteneor de letras

        //Crea guiones por cada letra de la palabra
        for (int i = 0; i < palabra.length(); i++) {
            Label guion = new Label("_");
            guion.setStyle("-fx-font-size: 25px;");
            contenedorLetras.getChildren().add(guion);
        }
    }

    /**
     * Actualiza la imagen del sol según la cantidad de errores
     * @param errores (Número de errores cometidos)
     */
    private void actualizarSol(int errores) {

        String ruta = "file:D:/JavaProjects/SolEclipsado/src/main/resources/img/sol" + errores + ".png";
        Image imagen = new Image(ruta);
        imagenSol.setImage(imagen);
    }

    /**
     * Permite al jugador usar una ayuda para descubrir la letra siguiente
     */
    @FXML
    private void usarAyuda() {

        int posicion = juego.usarAyuda();

        if (posicion != -1) {

            char letraCorrecta = juego.getPalabraSecreta().charAt(posicion);

            //Mostrar la letra
            Label letraLabel = (Label) contenedorLetras.getChildren().get(posicion);
            letraLabel.setText(String.valueOf(letraCorrecta));

            //Avanzar a la siguiente letra
            if (posicion == posicionActual) {
                posicionActual++;
            }

        } else {
            botonAyuda.setDisable(true); //Desactiva el botón después de tres ayudas
        }
    }
    /**
     * Muestra un mensaje en pantalla al usuario.
     * @param mensaje Texto que se desea mostrar
     */
    private void mostrarMensaje(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    /**
     * Bloquea la interacción del usuario cuando el juego termina.
     */
    private void bloquearJuego() {
        campoLetra.setDisable(true);
        botonAyuda.setDisable(true);
    }
}