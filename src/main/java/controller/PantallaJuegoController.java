package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import main. java.model.Juego;


//Metodo para recibir la palabra secreta
public class PantallaJuegoController {

    @FXML
    private HBox contenedorLetras;

    private Juego juego;

    public void iniciarJuego(String palabra) {
        juego = new Juego(palabra);

        System.out.println("Juego iniciado con palabra: " + palabra);
    }

}