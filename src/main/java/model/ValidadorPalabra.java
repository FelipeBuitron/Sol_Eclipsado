package main.java.model;

public class ValidadorPalabra {

    public static boolean palabraValida(String palabra){

        if(palabra == null){
            return false;
        }

        palabra = palabra.trim();

        if(palabra.length() < 6 || palabra.length() > 12){
            return false;
        }

        if(!palabra.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+")){
            return false;
        }

        return true;
    }
}
