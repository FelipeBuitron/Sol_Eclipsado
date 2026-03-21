package main.resources.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import main.java.model.ValidadorPalabra;

/**
 * CLASE DE LA PANNTALLA DE INICIO DEL JUEGO
 * Permite al usuario ingresar una palabra secreta y validarla antes de iniciar el juego
 *
 * @author Andrés Felipe Escobar
 * @author Carlos Enrique Delgado
 * @version 1.0
 */

public class PantallaInicio {

    /**
     * Muestra la ventana de inicio del juego.
     * @param stage (Ventana principal donde se carga la interfaz)
     */
    public void mostrar(Stage stage){

        Label titulo = new Label("SOL ECLIPSADO");

        Label instruccion = new Label("Ingrese la palabra secreta");

        TextField campoPalabra = new TextField();

        Button botonJugar = new Button("Jugar");

        botonJugar.setOnAction(e -> {

            String palabra = campoPalabra.getText();
            //Valida la palabra ingresada
            if(!ValidadorPalabra.palabraValida(palabra)){

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error");
                alerta.setHeaderText(null);
                alerta.setContentText("La palabra debe tener entre 6 y 12 letras y solo contener letras.");

                alerta.showAndWait();

            } else {

                System.out.println("Palabra válida: " + palabra);

            }
        });
        //Contenedor principal
        VBox root = new VBox(15);
        root.getChildren().addAll(titulo, instruccion, campoPalabra, botonJugar);

        //Crea la escena
        Scene escena = new Scene(root,800,800);

        //Configura la ventana
        stage.setScene(escena);
        stage.setTitle("Sol Eclipsado");
        stage.show();
    }
}