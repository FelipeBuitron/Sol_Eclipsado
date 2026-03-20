package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
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
                System.out.println("Letra correcta");

            } else {

                actualizarSol(juego.getErrores());
                System.out.println("Letra incorrecta");
            }

            campoLetra.clear();
        }
    }

    public void iniciarJuego(String palabra) {

        juego = new Juego(palabra);

        System.out.println("Juego iniciado con palabra: " + palabra);

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

            // Obtener la letra correcta
            char letraCorrecta = juego.getPalabraSecreta().charAt(posicion);

            // Mostrarla en pantalla
            Label letraLabel = (Label) contenedorLetras.getChildren().get(posicion);
            letraLabel.setText(String.valueOf(letraCorrecta));

            // Si la ayuda es justo en la posición actual, avanzamos
            if (posicion == posicionActual) {
                posicionActual++;
            }

            System.out.println("Ayuda usada en posición: " + posicion);

        } else {
            System.out.println("No tienes más ayudas 😢");
            botonAyuda.setDisable(true);
        }
    }
}