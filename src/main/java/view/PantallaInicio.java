package main.java.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import main.java.model.ValidadorPalabra;



public class PantallaInicio {

    public void mostrar(Stage stage){

        Label titulo = new Label("SOL ECLIPSADO");

        Label instruccion = new Label("Ingrese la palabra secreta");

        TextField campoPalabra = new TextField();

        Button botonJugar = new Button("Jugar");

        botonJugar.setOnAction(e -> {

            String palabra = campoPalabra.getText();

            if(!ValidadorPalabra.palabraValida(palabra)){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("La palabra debe tener entre 6 y 12 letras y solo contener letras.");

                alerta.showAndWait();

            } else {

                System.out.println("Palabra válida: " + palabra);

                //lllll

            }
        });

        VBox root = new VBox(15);
        root.getChildren().addAll(titulo, instruccion, campoPalabra, botonJugar);

        Scene escena = new Scene(root,800,800);

        stage.setScene(escena);
        stage.setTitle("Sol Eclipsado");
        stage.show();
    }
}