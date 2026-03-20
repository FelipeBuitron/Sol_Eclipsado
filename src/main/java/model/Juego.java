package main.java.model;

public class Juego {

    private String palabraSecreta;
    private int errores;
    private int ayudasRestantes;
    private boolean[] letrasAdivinadas;

    // Constructor
    public Juego(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toLowerCase();
        this.errores = 0;
        this.ayudasRestantes = 3;
        this.letrasAdivinadas = new boolean[palabraSecreta.length()];
    }

    // Getters
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public int getErrores() {
        return errores;
    }

    public int getAyudasRestantes() {
        return ayudasRestantes;
    }

    public boolean letraCorrectaEn(int posicion) {
        return letrasAdivinadas[posicion];
    }

    // 🔥 Método principal: validar letra en una posición
    public boolean verificarLetra(int posicion, char letra) {

        letra = normalizar(letra);
        char letraReal = normalizar(palabraSecreta.charAt(posicion));

        if (letraReal == letra) {
            letrasAdivinadas[posicion] = true;
            return true;
        } else {
            errores++;
            return false;
        }
    }

    // 🔥 Normalizar acentos
    private char normalizar(char c) {
        c = Character.toLowerCase(c);

        switch (c) {
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó': return 'o';
            case 'ú': return 'u';
            default: return c;
        }
    }

    // 🔥 Verificar si ganó
    public boolean juegoGanado() {
        for (boolean letra : letrasAdivinadas) {
            if (!letra) {
                return false;
            }
        }
        return true;
    }

    // 🔥 Verificar si perdió
    public boolean juegoPerdido() {
        return errores >= 5;
    }

    // 🔥 Usar ayuda (revela una letra automáticamente)
    public int usarAyuda() {

        if (ayudasRestantes > 0) {
            for (int i = 0; i < letrasAdivinadas.length; i++) {
                if (!letrasAdivinadas[i]) {
                    letrasAdivinadas[i] = true;
                    ayudasRestantes--;
                    return i; // posición revelada
                }
            }
        }

        return -1; // no hay ayuda disponible
    }
}
