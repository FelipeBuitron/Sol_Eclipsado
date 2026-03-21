package main.resources.view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * CLASE DE LA PANTALLA DE JUEGO
 * Genera una interfaz para el juego
 *
 * @author Andrés Felipe Escobar
 * @author Carlos Enrique Delgado
 * @version 1.0
 */
public class PantallaJuego {

    /**
     * Muestra la pantalla de juego
     * crea dinamicamente un campo de texto por cada letra de la palabra secreta
     * @param stage (Ventana principal donde se muestra la interfaz)
     * @param palabra (Palabra que el jugador debe adivinar)
     */
    public void mostrar(Stage stage, String palabra){

        HBox cajaLetras = new HBox(10);

        //Crea un campo de texto por cada letra de la palabra
        for(int i = 0; i < palabra.length(); i++){

            TextField letra = new TextField();
            letra.setPrefWidth(60);

            cajaLetras.getChildren().add(letra);

        }

        Scene escena = new Scene(cajaLetras, 500, 200);

        stage.setScene(escena);
        stage.setTitle("Juego - Sol Eclipsado");
    }
}
