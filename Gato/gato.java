/*Jesus Alejandro Montes Aguila 
 * Ingenieria en Comunicaciones y Electronica
 * Registro 224006131
 * 30 nov 2024
 */
import java.util.Scanner;
public class gato {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Tablero inicializado como matriz de Strings
        String[][] tablero = {
            {"11", "12", "13"},
            {"21", "22", "23"},
            {"31", "32", "33"}
        };

        boolean turnoJugadorX = true; // Alterna entre Jugador X y Jugador O
        int movimientos = 0; // Contador de movimientos

        while (movimientos < 9) { // El juego permite un máximo de 9 movimientos
            // Mostrar el tablero
            mostrarTablero(tablero);

            // Mensaje para el jugador actual
            System.out.println("Turno del jugador " + (turnoJugadorX ? "X" : "O"));
            System.out.println("Selecciona la posición del tablero:");

            String posicion = leer.next(); // Leer posición como cadena

            // Procesar la jugada
            boolean jugadaValida = marcarTablero(tablero, posicion, turnoJugadorX ? "X" : "O");
            if (jugadaValida) {
                movimientos++; // Incrementar el contador de movimientos
                // Verificar si alguien ganó
                String ganador = verificarGanador(tablero);
                if (ganador != null) {
                    mostrarTablero(tablero);
                    System.out.println("¡El jugador " + ganador + " ha ganado!");
                    return; // Finalizar el juego
                }
                // Cambiar turno
                turnoJugadorX = !turnoJugadorX;
            } else {
                System.out.println("Posición inválida o ya ocupada. Intenta de nuevo.");
            }
        }

        // Si se llena el tablero y no hay ganador
        mostrarTablero(tablero);
        System.out.println("¡Es un empate!");
    }

    // Método para mostrar el tablero
    public static void mostrarTablero(String[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Método para marcar el tablero
    public static boolean marcarTablero(String[][] tablero, String posicion, String marca) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals(posicion)) {
                    tablero[i][j] = marca;
                    return true; // Marcado exitoso
                }
            }
        }
        return false; // La posición no es válida o ya está ocupada
    }

    // Método para verificar si alguien ha ganado
    public static String verificarGanador(String[][] tablero) {
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0];
            }
        }

        // Verificar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j].equals(tablero[1][j]) && tablero[1][j].equals(tablero[2][j])) {
                return tablero[0][j];
            }
        }

        // Verificar diagonales
        if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0];
        }
        if (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2];
        }

        // Si no hay ganador
        return null;
    }
}
