package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CLASE PRINCIPAL DEL PROGRAMA
 * Se encarga de iniciar la aplicacion JavaFX y cargar la pantalla inicial del juego
 *
 * @author Andrés Felipe Escobar
 * @author Carlos Enrique Delgado
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Metodo principal de JavaFX
     * Inicializa la ventana principal y carga la interfaz de la pantalla de inicio.
     *
     * @param stage (Ventana principal de la aplicacion))
     * @throws Exception (En caso de error al cargar la inetrfaz)
     */
    @Override
    public void start(Stage stage) throws Exception {
        //Carga el archio FXMLde la pantalla de inicio
        FXMLLoader loader = new FXMLLoader(
                Main.class.getResource("/main/resources/view/pantalla_instrucciones.fxml")
        );

        //Crea la escena con el contenido cargado
        Scene scene = new Scene(loader.load());

        //Configura la ventana
        stage.setTitle("Sol Eclipsado");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Método main que lanza la aplicación.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}