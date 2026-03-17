package main.java.model;

public class Juego {

    private String palabraSecreta;
    private int errores;
    private int ayudasRestantes;
    private boolean[] letrasAdivinadas;

    //Metodo constructor del juego
    public Juego(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.errores = 0;
        this.ayudasRestantes = 3;
        this.letrasAdivinadas = new boolean[palabraSecreta.length()];
    }

    //Metodos getters básicos
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public int getErrores() {
        return errores;
    }

    public int getAyudasRestantes() {
        return ayudasRestantes;
    }

    //Metodo para aumentar los errores
    public void aumentarError() {
        errores++;
    }

    //metodo para usar ayuda
    public boolean usarAyuda() {

        if (ayudasRestantes > 0) {
            ayudasRestantes--;
            return true;
        }

        return false;
    }
    //Metodo para validar si una posicion de la plabara ya esta correcta
    public boolean letraCorrectaEn(int posicion) {
        return letrasAdivinadas[posicion];
    }

    //Metodo para verificar la posicion y la letra correcta
    public boolean verificarLetra(int posicion, char letra) {

        letra = Character.toLowerCase(letra);

        if (palabraSecreta.charAt(posicion) == letra) {
            letrasAdivinadas[posicion] = true;
            return true;
        } else {
            aumentarError();
            return false;
        }
    }
    //Metodo para verificar el ganador del juego
    public boolean juegoGanado() {

        for (boolean letra : letrasAdivinadas) {
            if (!letra) {
                return false;
            }
        }

        return true;
    }
}