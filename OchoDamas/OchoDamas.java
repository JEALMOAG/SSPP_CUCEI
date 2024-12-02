public class OchoDamas {
    final int N = 8; // Tamaño del tablero (8x8)

    public static void main(String[] args) {
        OchoDamas ochoDamas = new OchoDamas();
        ochoDamas.resolver();
    }

    // Método principal para resolver el problema
    void resolver() {
        int[][] tablero = new int[N][N];

        if (colocarReinas(tablero, 0)) {
            imprimirTablero(tablero);
        } else {
            System.out.println("No se encontró solución.");
        }
    }

    // Método recursivo para colocar reinas en el tablero
    boolean colocarReinas(int[][] tablero, int fila) {
        if (fila >= N) {
            return true; // Todas las reinas están colocadas
        }

        for (int columna = 0; columna < N; columna++) {
            if (esSeguro(tablero, fila, columna)) {
                tablero[fila][columna] = 1; // Colocar reina

                if (colocarReinas(tablero, fila + 1)) {
                    return true; // Intentar con la siguiente fila
                }

                tablero[fila][columna] = 0; // Backtracking: quitar reina
            }
        }
        return false; // No es posible colocar una reina en esta fila
    }

    // Verifica si es seguro colocar una reina en tablero[fila][columna]
    boolean esSeguro(int[][] tablero, int fila, int columna) {
        // Verificar la columna hacia arriba
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior derecha
        for (int i = fila, j = columna; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true; // Es seguro colocar la reina
    }

    // Método para imprimir el tablero
    void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((tablero[i][j] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
    }
}
