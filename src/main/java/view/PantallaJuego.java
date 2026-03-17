package main.java.view;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PantallaJuego {

    public void mostrar(Stage stage, String palabra){

        HBox cajaLetras = new HBox(10);

        for(int i = 0; i < palabra.length(); i++){

            TextField letra = new TextField();
            letra.setPrefWidth(40);

            cajaLetras.getChildren().add(letra);

        }

        Scene escena = new Scene(cajaLetras, 500, 200);

        stage.setScene(escena);
        stage.setTitle("Juego - Sol Eclipsado");
    }
}
